/*
NodePQ: id, cumulated_dist
NodeGraph: id, edge
*/

/*
https://www.spoj.com/problems/TRAFFICN/
*/

import java.io.*;
import java.util.*;

/*
s, t

dijkstra(s): distS[i] 
...(t): distT[i]

=> (u, v, w)


distS[u] + w + distT[v]
(s, u) (u, t)
distT (t -> ...)

distT[u] + w + distS[v]
*/

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
  public static int[] dist_S;
  public static int[] dist_T;
  public static ArrayList<ArrayList<Node>> graph_S;
  public static ArrayList<ArrayList<Node>> graph_T;

	public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    for(int i = 0; i < N; i++) {
      long minDist = Integer.MAX_VALUE;
      
      int n = scan.nextInt();
      int m = scan.nextInt();
      int k = scan.nextInt();
      int s = scan.nextInt();
      int t = scan.nextInt();
      graph_S = new ArrayList<ArrayList<Node>>();
      graph_T = new ArrayList<ArrayList<Node>>();
      for(int j = 0; j < n; j++) {
        graph_S.add(new ArrayList<Node>());
        graph_T.add(new ArrayList<Node>());
      }
      for(int j = 0; j < m; j++) {
        int u = scan.nextInt();
        int v = scan.nextInt();
        int d = scan.nextInt();
        graph_S.get(u-1).add(new Node(v-1, d));
        graph_T.get(v-1).add(new Node(u-1, d));
      }
      
      dist_S = new int[n];
      dist_T = new int[n];
      for(int j = 0; j < n; j++) {
        dist_S[j] = 1000000000;
        dist_T[j] = 1000000000;
      }
      
      
      dijkstra(s-1, dist_S, graph_S);
      dijkstra(t-1, dist_T, graph_T);
      //boolean noPath = false;
      // if(dist_S[t-1] == Integer.MAX_VALUE) {
      //   System.out.println(-1);
      //   //noPath = true;
      // }
      //System.out.printf("Test %d\n", i);
      
      for(int j = 0; j < k; j++) {
        int u = scan.nextInt();
        int v = scan.nextInt();
        int d = scan.nextInt();
        
        long shortTest_1 = dist_S[u-1] + d + dist_T[v-1];
        long shortTest_2 = dist_T[u-1] + d + dist_S[v-1];
        long minShortest = Math.min(shortTest_1, shortTest_2);
        
        minDist = Math.min(minDist, minShortest);
      }
      
      
      if (minDist >= 1000000000) {
        System.out.println(-1);
        continue;
      }
      
      System.out.println(minDist);
    }
	}
  
  
  
  public static void dijkstra(int s, int[] dist, ArrayList<ArrayList<Node>> graph) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    int n = graph.size();
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
        }
      }
    }
  }
  
}

