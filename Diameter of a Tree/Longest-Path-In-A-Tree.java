/*
https://www.spoj.com/problems/PT07Z/
*/

/*
First method: DFS twice
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

class MyCode {
    static int N;
    static List<List<Integer>> graph;
    static int dist[];

    public static void main(String[] args) {
        FastReader scan = new FastReader(System.in);
        N = scan.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            int u = scan.nextInt() - 1;
            int v = scan.nextInt() - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        solve();
    }

    private static void solve() {
        dist = new int[N];
        int r = 0;
        int maxDist = -1;
        for (int iter = 1; iter <= 2; ++iter) {
            dist[r] = 0;
            dfs(r, r);

            int furthestVertex = -1;
            maxDist = -1;
            for (int i = 0; i < N; i++) {
                if (dist[i] > maxDist) {
                    maxDist = dist[i];
                    furthestVertex = i;
                }
            }

            r = furthestVertex;
        }
        System.out.println(maxDist);
    }

    private static void dfs(int u, int p) {
        for (int neighbor : graph.get(u)) {
            if (neighbor != p) {
                dist[neighbor] = dist[u] + 1;
                dfs(neighbor, u);
            }
        }
    }

}




/*
Second method: DP
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

class MyCode {
    static int N;
    static List<List<Integer>> graph;
    static int[][] dp;

    public static void main(String[] args) {
        FastReader scan = new FastReader(System.in);
        N = scan.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            int u = scan.nextInt() - 1;
            int v = scan.nextInt() - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        solve();
    }

    private static void solve() {
        dp = new int[N][2];
        dfs(0, 0);
        int diameter = -1;
        for (int i = 0; i < N; i++) {
            diameter = Math.max(diameter, dp[i][0] + dp[i][1]);
        }
        System.out.println(diameter);
    }

    private static void dfs(int u, int p) {
        dp[u][0] = dp[u][1] = 0;
        for (int v : graph.get(u)) {
            if (v != p) {
                dfs(v, u);
                if (dp[v][0] + 1 >= dp[u][0]) {
                    dp[u][1] = dp[u][0];
                    dp[u][0] = dp[v][0] + 1;
                } else if (dp[v][0] + 1 >= dp[u][1]) {
                    dp[u][1] = dp[v][0] + 1;
                }
            }
        }
    }

}



