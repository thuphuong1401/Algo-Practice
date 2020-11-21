/*
https://www.spoj.com/PRE2020/problems/MICEMAZE/
Idea: reverse all the edges, then run Djikstra just once from the start vertex.
In that sense, one doesn't need to run Djikstra from each vertex.
*/
import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
  public Integer id;
  public Integer dist; // distance from starting node to id node
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
  public static int[] dist;
  public static int[] path;
  public static ArrayList<ArrayList<Node>> graph;
	
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int e = scan.nextInt();
    int t = scan.nextInt();
    int m = scan.nextInt();
    
    graph = new ArrayList<ArrayList<Node>>();
    for(int i = 0; i < n; i++) {
      graph.add(new ArrayList<Node>());      
    }
    
    for(int i = 0; i < m; i++) {
      int u = scan.nextInt();
      int v = scan.nextInt();
      int d = scan.nextInt();
      graph.get(v-1).add(new Node(u-1, d));
    }
    
    Dijkstra(e-1);
    
    int count = 0;
    for(int i = 0; i < n; i++) {
      if(dist[i] <= t) {
        //System.out.println(i);
        count++;
      }
    }
    System.out.println(count);
	}
  
  
  public static void Dijkstra(int s) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    int n = graph.size();
    dist = new int[n];
    path = new int[n];
    for(int i = 0; i < n; i++) {
      dist[i] = Integer.MAX_VALUE;
      path[i] = -1;
    }
    pq.add(new Node(s, 0));
    dist[s] = 0;
    
    while(!pq.isEmpty()) {
      Node top = pq.poll();
      int u = top.id;
      int w = top.dist;
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
  
  
  
  
  
