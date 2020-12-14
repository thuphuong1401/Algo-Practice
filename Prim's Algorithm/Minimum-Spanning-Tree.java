/*
https://www.spoj.com/problems/MST/
*/
import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    public Integer id;
    public Integer dist;
    public Node(Integer id, Integer dist) {
        this.id = id;
        this.dist = dist;
    }
    @Override
    public int compareTo(Node other) {
        return this.dist.compareTo(other.dist);
    }
}

class MyCode {
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    static int[] path;
    static boolean[] visited;
    static int n, m;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        graph = new ArrayList<ArrayList<Node>>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<Node>());
        }
        for(int i = 0; i < m; i++) {
            int u = scan.nextInt()-1;
            int v = scan.nextInt()-1;
            int w = scan.nextInt();
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }
        prims(0);
        printMST();
	}
    
    public static void prims(int src) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[n];
        path = new int[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            path[i] = -1;
            visited[i] = false;
        }
        pq.add(new Node(src, 0));
        dist[src] = 0;
        while(!pq.isEmpty()) {
            Node top = pq.poll();
            int u = top.id;
            visited[u] = true;
            for(int i = 0; i < graph.get(u).size(); i++) {
                Node neighbor = graph.get(u).get(i);
                int v = neighbor.id;
                int w = neighbor.dist;
                if(!visited[v] && w < dist[v]) {
                    dist[v] = w;
                    pq.add(new Node(v, w));
                    path[v] = u;
                }
            }
        }
    }
    
    public static void printMST() {
        long ans = 0;
        for(int i = 0; i < n; i++) {
            if(path[i] == -1) {
                continue;
            }
            ans += dist[i];
        }
        System.out.println(ans);
    }
    
}
