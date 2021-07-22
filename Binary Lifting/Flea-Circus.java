/*
https://onlinejudge.org/external/109/10938.pdf
Upshot: length of path(u, v) = length(u) + length(v) - 2 * length(lca(u, v))
*/

import java.util.*;
import java.io.*;

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader(InputStream in) {
        br = new BufferedReader(new InputStreamReader(in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

class Edge {
    int v;
    long w;

    public Edge(int v, long w) {
        this.v = v;
        this.w = w;
    }
}

class Main {
    static int N;
    static List<List<Integer>> graph;
    static int[] dist;
    static int l;
    static int[] tin;
    static int[] tout;
    static int time;
    static int[][] parents;

    public static void main(String[] args) {
        FastReader scan = new FastReader(System.in);
        PrintWriter pr = new PrintWriter(System.out);
        while (true) {
            N = scan.nextInt();
            if (N == 0) {
                break;
            }
            graph = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < N - 1; i++) {
                int a = scan.nextInt() - 1;
                int b = scan.nextInt() - 1;
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            preprocess();
            int q = scan.nextInt();
            while (q-- > 0) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                if (dist[u] < dist[v]) {
                    int temp = u;
                    u = v;
                    v = temp;
                }
                int lca = LCA(u, v);
                int length = dist[u] + dist[v] - 2 * dist[lca];
                if (length % 2 == 0) {
                    int meet = kthAncestor(u, length / 2);
                    pr.write("The fleas meet at " + (meet + 1) + ".\n");
                } else {
                    int meet1 = kthAncestor(u, length / 2);
                    int meet2 = parents[meet1][0];
                    if (meet1 > meet2) {
                        int temp = meet1;
                        meet1 = meet2;
                        meet2 = temp;
                    }
                    pr.write("The fleas jump forever between " + (meet1 + 1) + " and " + (meet2 + 1) + ".\n");
                }
            }
        }
        pr.close();
    }

    private static int log2(int n) {
        return (int) (Math.log(n) / Math.log(2));
    }

    private static void dfs(int u, int p) {
        time++;
        tin[u] = time;
        parents[u][0] = p;
        dist[u] = dist[p] + 1;
        for (int neighbor : graph.get(u)) {
            if (neighbor != p) {
                dfs(neighbor, u);
            }
        }
        tout[u] = time;
    }

    private static void preprocess() {
        time = 0;
        l = log2(N);
        tin = new int[N];
        tout = new int[N];
        parents = new int[N][l + 1];
        dist = new int[N];

        dfs(0, 0);
        for (int k = 1; k <= l; k++) {
            for (int u = 0; u < N; u++) {
                parents[u][k] = parents[parents[u][k - 1]][k - 1];
            }
        }
    }

    private static boolean isAncestor(int u, int v) {
        return tin[u] <= tin[v] && tout[u] >= tout[v];
    }

    private static int LCA(int u, int v) {
        if (isAncestor(u, v)) {
            return u;
        }
        if (isAncestor(v, u)) {
            return v;
        }

        for (int k = l; k >= 0; k--) {
            if (!isAncestor(parents[u][k], v)) {
                u = parents[u][k];
            }
        }

        return parents[u][0];
    }

    private static int kthAncestor(int u, int k) {
        for (int i = l; i >= 0; i--) {
            int mask = (1 << i);
            if ((mask & k) != 0) {
                u = parents[u][i];
            }
        }
        return u;
    }

}
