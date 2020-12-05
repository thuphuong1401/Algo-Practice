/*
https://open.kattis.com/problems/shortestpath3
Approach: run Bellman-Ford twice.
1. First run: 
- Got dist array, 
*/

import java.io.*;
import java.util.*;

class Edge {
    public int source;
    public int target;
    public int weight;
    public Edge(int source, int target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;   
    }
}

class MyCode {
    
    static final int INF = (int) 1e9;
    static Edge[] graph;
    static int n, m, q, s;
    static int[] dist;
	
    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in);
        while(true) {
            n = scan.nextInt();
            m = scan.nextInt();
            q = scan.nextInt();
            s = scan.nextInt();
            if(n == 0) {
                break;
            }
            dist = new int[n];
            for(int i = 0; i < n; i++) {
                dist[i] = INF;
            }
            graph = new Edge[m];
            for(int i = 0; i < m; i++) {
                int u = scan.nextInt();
                int v = scan.nextInt();
                int w = scan.nextInt();
                graph[i] = new Edge(u, v, w);
            }
            
            BellmanFord(s);
            
            for(int i = 0; i < q; i++) {
                int target = scan.nextInt();
                /*
                If the query vertex belongs to a negative cycle, the source-target distance can be arbitrarily short
                since we can enter the cycle and loop forever
                The original Bellman-Ford only allows us to identify whether there exists a negative cycle or not.
                It does not identify which specific vertices are on such cycle
                */
                if(dist[target] == INF) {
                    System.out.println("Impossible");
                } else if(dist[target] == -INF) {
                    System.out.println("-Infinity");
                } else {
                    System.out.println(dist[target]);
                }
            }
            System.out.println();
        }
	}
    
    public static void BellmanFord(int s) {
        int u, v, w;
        dist[s] = 0;
        for(int i = 1; i <= n-1; i++) {
            for(int j = 0; j < m; j++) {
                u = graph[j].source;
                v = graph[j].target;
                w = graph[j].weight;
                if(dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        // Have to run Bellman-Ford again. Using 1 loop over all edges (1 to m) will only detect negative cycles
        for(int i = 1; i <= n-1; i++) {
            for(int j = 0; j < m; j++) {
                u = graph[j].source;
                v = graph[j].target;
                w = graph[j].weight;
                if(dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = -INF; // mark in the dist array that v belongs to a negative cycle
                }
            }            
        }
    }
}
