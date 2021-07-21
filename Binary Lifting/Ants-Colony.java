/*
https://onlinejudge.org/external/122/12238.pdf
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
    static List<List<Edge>> graph;
    static long[] dist;
    static int l;
    static int[] tin;
    static int[] tout;
    static int time;
    static int[][] parents;

    public static void main(String[] args) {
        FastReader scan = new FastReader(System.in);
        while (true) {
            N = scan.nextInt();
            if (N == 0) {
                return;
            }
            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }
            for (int u = 1; u <= N - 1; u++) {
                int v = scan.nextInt();
                long w = scan.nextLong();
                Edge edge1 = new Edge(v, w);
                Edge edge2 = new Edge(u, w);
                graph.get(u).add(edge1);
                graph.get(v).add(edge2);
            }
            dist = new long[N]; // dist[v]: distance from root to v
            preprocess();
            int Q = scan.nextInt();
            while (Q-- > 0) {
                int u = scan.nextInt();
                int v = scan.nextInt();
                int lca = LCA(u, v);
                long minDist = dist[u] + dist[v] - 2 * dist[lca];
                if (Q >= 1) {
                    System.out.print(minDist + " ");
                } else {
                    System.out.print(minDist);
                }
            }
            System.out.println();
        }
    }

    private static void dfs(int u, int p) {
        time++;
        tin[u] = time;
        parents[u][0] = p;
        for (Edge e : graph.get(u)) {
            int child = e.v;
            long d = e.w;
            if (child != p) {
                dist[child] = dist[u] + d;
                dfs(child, u);
            }
        }
        tout[u] = time;
    }

    private static boolean isAncestor(int u, int v) {
        return tin[u] <= tin[v] && tout[u] >= tout[v];
    }

    private static int log2(int n) {
        return (int) (Math.log(n) / Math.log(2));
    }

    private static void preprocess() {
        time = 0;
        l = log2(N);
        parents = new int[N][l + 1];
        tin = new int[N];
        tout = new int[N];
        dfs(0, 0);

        for (int k = 1; k <= l; k++) {
            for (int i = 0; i < N; i++) {
                parents[i][k] = parents[parents[i][k - 1]][k - 1];
            }
        }
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

}
