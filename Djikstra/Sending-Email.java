/*
https://onlinejudge.org/external/109/10986.pdf
*/

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    Integer id;
    Integer dist;
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
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        graph = new ArrayList<ArrayList<Node>>();
        int numTestCases = scan.nextInt();
        for(int i = 0; i < numTestCases; i++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int s = scan.nextInt();
            int t = scan.nextInt();
            for(int j = 0; j < n; j++) {
                graph.add(new ArrayList<Node>());
            }
            for(int j = 0; j < m; j++) {
                int server1 = scan.nextInt();
                int server2 = scan.nextInt();
                int w = scan.nextInt();
                graph.get(server1).add(new Node(server2, w));
                graph.get(server2).add(new Node(server1, w));                
            }
            djikstra(s);
            if(path[t] != -1) {
                System.out.println("Case #" + (i+1) + ": " + dist[t]);
            } else {
                System.out.println("Case #" + (i+1) + ": unreachable");
            }
            graph.clear();
        }
	}
    
    public static void djikstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int n = graph.size();
        dist = new int[n];
        path = new int[n];
        for(int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            path[i] = -1;
        }
        dist[s] = 0;
        pq.add(new Node(s, 0));
        while(!pq.isEmpty()) {
            Node top = pq.remove();
            int u = top.id;
            int w = top.dist;
            if(dist[u] != w) {
                continue;
            }
            for(int i = 0; i < graph.get(u).size(); i++) {
                Node neighbor = graph.get(u).get(i);
                if(w + neighbor.dist < dist[neighbor.id]) {
                    dist[neighbor.id] = w + neighbor.dist;
                    pq.add(new Node(neighbor.id, dist[neighbor.id]));
                    path[neighbor.id] = u;
                }
            }
        }
    }
}

