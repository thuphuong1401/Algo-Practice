/*
https://www.spoj.com/problems/LCA/
*/

// package whatever; // don't place package name!
// Installed Libraries: JSON-Simple, JUNit 4, Apache Commons Lang3
import java.io.*;
import java.util.*;


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


public class Main {
    
    static int N, Q, M;
    static List<List<Integer>> graph;
    static int l;
    static int[] tin; 
    static int[] tout;
    static int time;
    static int[][] parents;
    
	public static void main (String[] args) {
        FastReader scan = new FastReader(System.in);
        PrintWriter pr = new PrintWriter(System.out);
        int test = scan.nextInt();
        for(int t = 1; t <= test; t++) {
            N = scan.nextInt();
            graph = new ArrayList<>();
            
            for(int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }
            
            for(int i = 0; i < N; i++) {
                M = scan.nextInt();
                for(int j = 0; j < M; j++) {
                    int u = scan.nextInt() - 1;
                    graph.get(i).add(u);
                    graph.get(u).add(i);
                }
            }
            
            tin = new int[N];
            tout = new int[N];
            
            preprocess();
            
            Q = scan.nextInt();
            pr.write("Case " + t + ": \n");
            
            for(int i = 0; i < Q; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                pr.write(LCA(u, v) + 1 + "\n");
            }
        }
        pr.close();
	}
    
    private static void dfs(int u, int p) {
        time++;
        tin[u] = time;
        
        parents[u][0] = p;
        
        for(int child : graph.get(u)) {
            if(child != p) {
                dfs(child, u);
            }
        }
        
        tout[u] = time;
    }
    
    private static boolean isAncestor(int u, int v) {
        return tin[u] <= tin[v] && tout[u] >= tout[v];
    }
    
    public static int log2(int n) {
        int result = (int)(Math.log(n) / Math.log(2));
        return result;
    }
    
    private static void preprocess() {
        time = 0;
        l = log2(N);
        parents = new int[N][l+1];
        dfs(0, 0);
        
        for(int k = 1; k <= l; k++) {
            for(int i = 0; i < N; i++) {
                parents[i][k] = parents[parents[i][k-1]][k-1];
            }
        }
    }
    
    private static int LCA(int u, int v) {
        if(isAncestor(u, v)) {
            return u;
        }
        if(isAncestor(v, u)) {
            return v;
        }
        
        for(int k = l; k >= 0; k--) {
            if(!isAncestor(parents[u][k], v)) {
                u = parents[u][k];
            }
        }
        
        return parents[u][0];
        
    }
    
}
