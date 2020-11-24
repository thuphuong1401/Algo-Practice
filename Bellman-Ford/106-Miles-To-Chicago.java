/*
https://www.urionlinejudge.com.br/judge/en/problems/view/1655
*/

import java.io.*;
import java.util.*;

class Edge {
    public int source;
    public int target;
    public double weight;
    public Edge(int source, int target, double weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }
}

class MyCode {
    static final int INF = (int) 1e9;
    static List<Edge> graph;
    static double[] dist;
    static int[] path;
    static int n, m;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            n = scan.nextInt();
            if(n == 0) {
                break;
            }
            m = scan.nextInt();
            dist = new double[n+1];
            path = new int[n+1];
            Arrays.fill(dist, -INF); // initialized to -INF stead of INF because we want to find longest path, i.e. maximize probability
            Arrays.fill(path, -1);
            graph = new ArrayList<>();
            for(int i = 0; i < m; i++) {
                int u = scan.nextInt();
                int v = scan.nextInt();
                double w = scan.nextInt();
                // 2 directional edges
                graph.add(new Edge(u, v, w/100));
                graph.add(new Edge(v, u, w/100));
            }
            int s = 1;
            int t = n;
            BellmanFord(s);
            System.out.printf("%.6f percent\n", dist[t]*100);
        }
	}
    
    /*
    Modified Bellman-Ford
    */
    public static void BellmanFord(int s) {
        int u, v; 
        double w;
        dist[s] = 1; // Not =0 since the it's multiplication not addition
        for(int i = 0; i <= n-1; i++) {
            for(int j = 0; j < graph.size(); j++) {
                u = graph.get(j).source;
                v = graph.get(j).target;
                w = graph.get(j).weight;
                // Multiply (instead of addition) since we're calculating probability here :)
                // > instead of < because we want to MAXIMIZE the prob of not getting caught
                if(dist[u] != -INF && dist[u] * w > dist[v]) {
                    dist[v] = dist[u] * w;
                    path[v] = u;
                }
            }
        }
    }    
}

