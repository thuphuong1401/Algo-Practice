/*
https://vjudge.net/problem/LightOJ-1074
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
    public static final int MAX = (int) 1e9;
    public static int[] dist;
    public static Edge[] graph;
    public static int[] path;
    public static List<Integer> junction;
    public static int n, m;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        
        for(int i = 0; i < numTestCases; i++) {
            
            n = scan.nextInt();
            junction = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                junction.add(scan.nextInt());
            }
            m = scan.nextInt();
            graph = new Edge[m];
            dist = new int[n];
            path = new int[n];
            for(int j = 0; j < n; j++) {
                dist[j] = MAX;
                path[j] = -1;
            }
            for(int j = 0; j < m; j++) {
                int u = scan.nextInt()-1;
                int v = scan.nextInt()-1;
                int w = (int)Math.pow(junction.get(v) - junction.get(u), 3);
                graph[j] = new Edge(u, v, w);    
            }
            int numQuery = scan.nextInt();
            int s = 0;
            boolean res = BellmanFord(s);
            System.out.println("Case " + (i+1) + ":");
            for(int j = 0; j < numQuery; j++) {
                int t = scan.nextInt()-1;
                if(path[t] != -1 && dist[t] >= 3) {
                    System.out.println(dist[t]);
                } else {
                    System.out.println("?");
                }
            }
            junction.clear();
        }
	}
    
    public static boolean BellmanFord(int s) {
        int u, v, w;
        dist[s] = 0;
        for(int i = 1; i <= n-1; i++) {
            for(int j = 0; j < m; j++) {
                u = graph[j].source;
                v = graph[j].target;
                w = graph[j].weight;
                if(dist[u] != MAX && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    path[v] = u;
                }
            }
        }
        // Check for negative cycle
        for(int i = 0; i < m; i++) {
            u = graph[i].source;
            v = graph[i].target;
            w = graph[i].weight;
            if(dist[u] != MAX && dist[u] + w < dist[v]) {
                return false;
            }
        }
        return true;
    }
}


