/*
https://www.hackerearth.com/practice/algorithms/graphs/shortest-path-algorithms/practice-problems/algorithm/successful-marathon-0691ec04/
*/

import java.io.*;
import java.util.*;

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
    public static int[] distA;
    public static int[] distB;
    public static int[] pathA;
    public static int[] pathB;
    public static ArrayList<ArrayList<Node>> graph;
    public static List<Integer> cities;
    public static int x;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();
        x = scan.nextInt();
        cities = new ArrayList<Integer>();
        for(int i = 0; i < k; i++) {
            cities.add(scan.nextInt()-1);
        }
        graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<Node>());
        }
        for(int i = 0; i < m; i++) {
            int u = scan.nextInt()-1;
            int v = scan.nextInt()-1;
            int d = scan.nextInt();
            graph.get(u).add(new Node(v, d));
            graph.get(v).add(new Node(u, d));
        }
        int a = scan.nextInt()-1;
        int b = scan.nextInt()-1;
        
        distA = new int[n];
        distB = new int[n];
        pathA = new int[n];
        pathB = new int[n];
        
        for(int i = 0; i < n; i++) {
            distA[i] = Integer.MAX_VALUE;
            distB[i] = Integer.MAX_VALUE;
            pathA[i] = -1;
            pathB[i] = -1;
        }
        
        // find shortest path from a to k, from k to b
        dijkstra(a, distA, pathA);
        dijkstra(b, distB, pathB);
        
        // if there's no path from a to b
        if(pathA[b] == -1 && pathB[a] == -1) {
            System.out.println(-1);
            return;
        }
        
        int minTime = Integer.MAX_VALUE;
        for(int city : cities) {
            if(distB[city] <= x) { // A => city => B. Have to bring chocolate from city => B under x amount of time
                minTime = Math.min(minTime, distA[city] + distB[city]);    
            }
        }
        
        if(minTime == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(minTime);
	}
    
    public static void dijkstra(int s, int[] dist, int[] path) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dist[s] = 0;
        while(!pq.isEmpty()) {
            Node top = pq.remove();
            int u = top.id;
            int w = top.dist;
            if(w > dist[u]) {
                continue;
            }
            for(int i = 0; i < graph.get(u).size(); i++) {
                Node neighbor = graph.get(u).get(i);
                if(w + neighbor.dist < dist[neighbor.id]) {
                    dist[neighbor.id] = w + neighbor.dist;
                    path[neighbor.id] = u;
                    pq.add(new Node(neighbor.id, dist[neighbor.id]));
                }
            }
        }
    }
}
