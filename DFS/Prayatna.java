// package whatever; // don't place package name!

/*
https://vn.spoj.com/problems/CAM5/
*/

import java.io.*;
import java.util.*;

class MyCode {
  static ArrayList<ArrayList<Integer>> graph;
  static boolean[] visited;
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int numTestCases = scan.nextInt();
    for(int i = 0; i < numTestCases; i++) {
      int fewest = 0;
      int N = scan.nextInt();
      int E = scan.nextInt();
      graph = new ArrayList<>(N);
      
      for(int m = 0; m < N; m++) {
        graph.add(new ArrayList<Integer>());
      }
      
      for(int j = 0; j < E; j++) {
        int a = scan.nextInt();
        int b = scan.nextInt();
        graph.get(a).add(b);
        graph.get(b).add(a);
      }
      
      visited = new boolean[N];
      for(int k = 0; k < N; k++) { // DFS on all vertices
        if(!visited[k]) { // if not visited, DFS on this vertex
          DFS(k); 
          fewest++;
        } 
      }
      System.out.println(fewest);
    }
      
  }
  
  public static void DFS(int s) {
    visited[s] = true;
    for(int i = 0; i < graph.get(s).size(); i++) {
      int v = graph.get(s).get(i);
      if(!visited[v]) {
        DFS(v);
      }
    }
  }
}
