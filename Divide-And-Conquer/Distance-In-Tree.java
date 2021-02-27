/*
https://codeforces.com/problemset/problem/161/D
*/
import java.util.*;
import java.io.*;

class MyCode {
    
    private static List<List<Integer>> graph;
    private static int result;
    private static int n, k;
    private static int[][] dp;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        while(scan.hasNext()) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dp = new int[50001][501];
        result = 0;
        dfs(1, 0);
        System.out.println(result);
	}
    
    private static void dfs(int node, int parent) {
        dp[node][0] = 1;
        for(int child : graph.get(node)) {
            if(child != parent) {
                dfs(child, node);
                for(int i = 0; i <= k; i++) {
                    result += dp[node][i] * dp[child][k-i];
                    dp[node][i] += dp[child][i];
                }
            }
        }
        
        for(int i = k; i > 0; i--) {
            dp[node][i] = dp[node][i-1];
        }
        dp[node][0] = 0;
        
    }
    
}




