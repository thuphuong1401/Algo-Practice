// package whatever; // don't place package name!

// https://www.hackerrank.com/challenges/bfsshortreach/problem

import java.io.*;
import java.util.*;

class MyCode {
  private static ArrayList<ArrayList<Integer>> graph;
  private static int V;
  private static int E;
    
	public static void main (String[] args) {
    
    Scanner scan = new Scanner(System.in);
    int numTestCase = scan.nextInt();
    
    for(int i = 0; i < numTestCase; i++) {
      V = scan.nextInt();
      E = scan.nextInt();
      graph = new ArrayList<>(V+1);
      
      for(int j = 0; j < V+1; j++) {
        graph.add(new ArrayList<Integer>());
      }
      
      for(int j = 0; j < E; j++) {
        int u = scan.nextInt();
        int v = scan.nextInt();
        graph.get(u).add(v);
        graph.get(v).add(u);
      }
      
      int s = scan.nextInt();
      
      BFS(s);
      System.out.println();
      
    }
    
    
	}
  
  public static void BFS(int s) {
    Queue<Integer> queue = new LinkedList<Integer>();
    List<Boolean> visited = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    List<Integer> dist = new ArrayList<>();
    
    for(int i = 0; i < V+1; i++) {
      visited.add(false);
      path.add(-1);
      dist.add(-1);
    }
    
    visited.set(s, true);
    queue.add(s);
    dist.set(s, 0);
    
    
    while(!queue.isEmpty()) {
      int consider = queue.remove();
      for(int i = 0; i < graph.get(consider).size(); i++) {
        int u = graph.get(consider).get(i);
        if(!visited.get(u)) {
          // consider la dinh trung gian giua s va u
          dist.set(u, dist.get(consider) + 6);
          visited.set(u, true);
          path.set(u, consider);
          queue.add(u);
        }
      }  
    }
    
    for(int i = 1; i < V+1; i++) {
      if (i == s) {
        continue;
      }
      System.out.print(dist.get(i) + " ");
    }
  }
}



// }

