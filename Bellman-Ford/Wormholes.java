/*
http://www.cs.nthu.edu.tw/~progcont/ACM/ProblemSetArchive/B_EU_NWRC/1996/nwec96b.html
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
    public static final int MAX = (int)1e9;
    public static int[] dist;
    public static Edge[] graph;
    public static int[] path;
    public static int star, wormholes;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCase = scan.nextInt();
        for(int i = 0; i < numTestCase; i++) {
            star = scan.nextInt();
            wormholes = scan.nextInt();
            graph = new Edge[wormholes];
            dist = new int[star];
            path = new int[star];
            for(int j = 0; j < star; j++) {
                dist[j] = MAX;
                path[j] = -1;
            }
            for(int j = 0; j < wormholes; j++) {
                int u = scan.nextInt();
                int v = scan.nextInt();
                int w = scan.nextInt();
                graph[j] = new Edge(u, v, w);
            }
            int s = 0;
            boolean res = BellmanFord(s);
            if(!res) {
                System.out.println("possible");
            } else {
                System.out.println("not possible");
            }
        }
	}
    
    public static boolean BellmanFord(int s) {
        int u, v, w;
        dist[s] = 0;
        for(int i = 1; i <= star-1; i++) {
            for(int j = 0; j < wormholes; j++) {
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
        for(int i = 0; i < wormholes; i++) {
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

