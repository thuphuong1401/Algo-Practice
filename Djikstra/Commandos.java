/*
https://vjudge.net/problem/LightOJ-1174
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
    static int[] distS;
    static int[] distT;
    
	public static void main (String[] args) {        
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        graph = new ArrayList<ArrayList<Node>>();
        for(int i = 0; i < numTestCases; i++) {
            int n = scan.nextInt();
            for(int j = 0; j < n; j++) {
                graph.add(new ArrayList<Node>());
            }
            int r = scan.nextInt();
            for(int j = 0; j < r; j++) {
                int a = scan.nextInt();
                int b = scan.nextInt();
                graph.get(a).add(new Node(b, 1));
                graph.get(b).add(new Node(a, 1));    
            }        
            int s = scan.nextInt();
            int d = scan.nextInt();
            
            distS = new int[n];
            distT = new int[n];
            djikstra(s, distS);
            djikstra(d, distT);
            
            int answer = 0;
            
            for(int j = 0; j < n; j++) {
                answer = Math.max(answer, distS[j] + distT[j]);
            }
            System.out.println("Case " + (i+1) + ": " + answer);
            
            graph.clear();
            
        }
	}
    
    public static void djikstra(int s, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        pq.add(new Node(s, 0));
        dist[s] = 0;
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
                }
            }
        }
    }
}

