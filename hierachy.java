// package whatever; // don't place package name!

/*
https://vn.spoj.com/problems/MAKETREE/
*/

import java.io.*;
import java.util.*;


class MyCode {
  static ArrayList<ArrayList<Integer>> graph;
  static int N, K;
  
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    K = scan.nextInt();
    graph = new ArrayList<>(N+1);
    for(int i = 0; i <= N; i++) {
      graph.add(new ArrayList<Integer>());
    }
    for(int u = 1; u <= K; u++) {
      int x = scan.nextInt();
      while(x > 0) {
        int v = scan.nextInt();
        graph.get(u).add(v);
        x--;
      }
    }
    
    ArrayList<Integer> result = new ArrayList<>();
    topologicalSort(result);
    
    int[] boss = new int[N+1]; // boss[i] is the boss of i
    boss[result.get(0)] = 0;
    for(int i = 1; i < N; i++) {
      boss[result.get(i)] = result.get(i-1);
    }
    for(int i = 1; i < N+1; i++) {
      System.out.println(boss[i]);
    }
  }
  
  public static void dfs(int u, boolean[] visited, ArrayList<Integer> result) {
    visited[u] = true;
    for(int i = 0; i < graph.get(u).size(); i++) {
      int v = graph.get(u).get(i);
      if(!visited[v]) {
        dfs(v, visited, result);
      }
    }
    result.add(u);
  }
  
  
  public static void topologicalSort(ArrayList<Integer> result) {
    int V = N;
    boolean[] visited = new boolean[V+1];
    for(int i = 1; i < V+1; i++) {
      if(!visited[i]) {
        dfs(i, visited, result);
      }
    } 
    Collections.reverse(result);
  }
  
  
  
}
