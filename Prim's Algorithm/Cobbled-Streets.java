/*
https://www.spoj.com/problems/CSTREET/
Idea: just implement basic Prims, then get weight of MST * price    
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
    static int[] dist;
    static int[] path;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> graph;
    static int n, m, p;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        for(int l = 0; l < numTestCases; l++) {
            p = scan.nextInt();
            n = scan.nextInt();
            m = scan.nextInt();
            
            dist = new int[n];
            path = new int[n];
            visited = new boolean[n];
            graph = new ArrayList<ArrayList<Node>>();
            
            Arrays.fill(dist, Integer.MAX_VALUE);
            Arrays.fill(path, -1);
            for(int i = 0; i < n; i++) {
                graph.add(new ArrayList<Node>());
            }

            for(int i = 0; i < m; i++) {
                int a = scan.nextInt()-1;
                int b = scan.nextInt()-1;
                int c = scan.nextInt();
                graph.get(a).add(new Node(b, c));
                graph.get(b).add(new Node(a, c));
            }
            prims(0);
            long answer = 0;
            for(int k : dist) {
                answer += k;
            }
            long minPrice = p * answer;
            System.out.println(minPrice);
        }
	}
    
    public static void prims(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[s] = 0;
        pq.add(new Node(s, 0));
        while(!pq.isEmpty()) {
            Node top = pq.remove();
            int u = top.id;
            int w = top.dist;
            visited[u] = true;
            for(int i = 0; i < graph.get(u).size(); i++) {
                Node neighbor = graph.get(u).get(i);
                if(!visited[neighbor.id] && dist[neighbor.id] > neighbor.dist) {
                    dist[neighbor.id] = neighbor.dist;
                    path[neighbor.id] = u;
                    pq.add(new Node(neighbor.id, dist[neighbor.id]));
                }
            }
        }
    }
}
