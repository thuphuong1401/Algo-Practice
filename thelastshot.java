// package whatever; // don't place package name!
/*
https://www.spoj.com/problems/LASTSHOT/
*/


import java.io.*;
import java.util.*;

class MyCode {
  static ArrayList<ArrayList<Integer>> graph;
  static boolean[] visited;
  static int count = 0;
  
	public static void main (String[] args) {
    
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();
    graph = new ArrayList<>(n+1);
    for(int i = 0; i < n+1; i++) {
      graph.add(new ArrayList<Integer>());
    }
    
    for(int i = 0; i < m; i++) {
      int a = scan.nextInt();
      int b = scan.nextInt();
      graph.get(a).add(b);
      //graph.get(b).add(a);  
    }
    
    int maxImpact = 0;
    for(int i = 0; i < n+1; i++) {
      visited = new boolean[n+1];
      DFS(i);
      if(maxImpact < count) {
        maxImpact = count;
      }
      count = 0;
    }
    
    System.out.println(maxImpact);
    
	}
  
  public static void DFS(int s) {
    visited[s] = true;
    count++;
    for(int i = 0; i < graph.get(s).size(); i++) {
      int v = graph.get(s).get(i);
      if(!visited[v]) {
        DFS(v);
      }
    }
  }
}
