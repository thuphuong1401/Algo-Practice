/*
https://www.hackerearth.com/practice/algorithms/graphs/shortest-path-algorithms/practice-problems/algorithm/monks-business-day/
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
    static int[] dist;
    static int[] path;
    static int n, m;
    
    public static void main (String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        for(int i = 0; i < numTestCases; i++) {
            n = scan.nextInt();
            m = scan.nextInt();
            graph = new Edge[m];
            for(int j = 0; j < m; j++) {
                int one = scan.nextInt();
                int two = scan.nextInt();
                int c = scan.nextInt();
                graph[j] = new Edge(one, two, c);
            }
            dist = new int[n+1];
            path = new int[n+1];
            Arrays.fill(dist, -INF); // initialize this to -INF
            Arrays.fill(path, -1);

            boolean answer = BellmanFord(1);
            if(!answer) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
	}
    
    /*
    Modified Bellman-Ford to find positive cycle
    Instead of finding shortest path, we find LONGEST PATH
    */
    public static boolean BellmanFord(int s) {
        int u, v, w;
        dist[s] = 0;
        for(int i = 1; i <= n-1; i++) {
            for(int j = 0; j < m; j++) {
                u = graph[j].source;
                v = graph[j].target;
                w = graph[j].weight;
                // 2nd condition: seeing a longer path, update
                if (dist[u] != -INF && dist[u] + w > dist[v]) {
                    dist[v] = dist[u] + w;
                    path[v] = u;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            u = graph[i].source;
            v = graph[i].target;
            w = graph[i].weight;
            if(dist[u] != -INF && dist[u] + w > dist[v]) {
                return false;
            }
        }
        return true;
    }
}




