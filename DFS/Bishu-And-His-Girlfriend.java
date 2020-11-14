/*
https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/bishu-and-his-girlfriend/description/
*/

// package whatever; // don't place package name!

import java.io.*;
import java.util.*;

class MyCode {
  static int N = 0;
  static int Q = 0;
  static ArrayList<ArrayList<Integer>> graph;
  static int[] dist;
  
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    graph = new ArrayList<>();
    for(int i = 0; i < N+1; i++) {
      graph.add(new ArrayList<Integer>(N+1));
    }
    for(int i = 0; i < N-1; i++) {
      int u = scan.nextInt();
      int v = scan.nextInt();
      graph.get(u).add(v);
      graph.get(v).add(u);
    }  
    Q = scan.nextInt();
    int[] pos = new int[Q+1];
    for(int i = 1; i <= Q; i++) {
      pos[i] = scan.nextInt();
    }
    
    // DFS to find min distance
    int s = 1;
    dist = new int[N+1];
    DFS(s); // return distance array (dist[i] = distance from root to vertex i)
    
    int min = Integer.MAX_VALUE;
    int girl = -1;
    
    int[] distOfGirls = new int[N+1];
    for(int i = 0; i < N+1; i++) {
      distOfGirls[i] = -1;
    }
    for(int i = 0; i < Q+1; i++) {
      distOfGirls[pos[i]] = dist[pos[i]];
    }
    for(int i = 1; i < N+1; i++) {
      if(distOfGirls[i] != -1 && distOfGirls[i] < min) {
        min = distOfGirls[i];
        girl = i;
      }
    }
    
    
    System.out.println(girl);
    
  }
  
  public static void DFS(int s) {
    boolean[] visited = new boolean[N+1];
    Stack<Integer> stack = new Stack<>();
    visited[s] = true;
    stack.add(s);
    while(!stack.isEmpty()) {
      int u = stack.pop();
      for(int i = 0; i < graph.get(u).size(); i++) {
        int v = graph.get(u).get(i);
        if(!visited[v]) {
          visited[v] = true;
          dist[v] = dist[u] + 1;
          stack.add(v);
        }
      }
    }
  }
  
  
}
