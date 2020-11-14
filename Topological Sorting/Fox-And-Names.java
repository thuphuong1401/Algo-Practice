// package whatever; // don't place package name!

/*
https://codeforces.com/problemset/problem/510/C
*/

import java.io.*;
import java.util.*;

class MyCode {
  static boolean[][] graph;
  static ArrayList<ArrayList<Integer>> newGraph;
  
	public static void main (String[] args) {
    
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    String[] input = new String[n];
    for(int i = 0; i < n; i++) {
      input[i] = scan.next();
    }
    
    graph = new boolean[26][26]; 
    for(int i = 0; i < n-1; i++) {
      boolean flag = false;
      for(int j = 0; j < Math.min(input[i].length(), input[i+1].length()); j++) {
        int a = (int) input[i].charAt(j) - 97;
        int b = (int) input[i+1].charAt(j) - 97;
        if(a != b) {
          graph[a][b] = true; 
          flag = true;
          // System.out.println("hihi");
          break;
        }
      }
      // if length of string i > length of string i+1 => return impossible
      if(flag == false && input[i].length() > input[i+1].length()) { 
        System.out.println("Impossible");
        return;
      }
    }
    
    convert(graph);
    ArrayList<Integer> result = new ArrayList<>();
    boolean x = topologicalSort(result);
    if(x) {
      Collections.reverse(result);
      for(int i : result) {
        i = i + 97;
        char a = (char) i;
        System.out.print(a);
      }    
    } else {
      System.out.println("Impossible");
    }
    
  
    
	}
  
  public static void convert(boolean[][] g) {
    newGraph = new ArrayList<>(g.length);
    for(int i = 0; i < g.length; i++) {
      newGraph.add(new ArrayList<Integer>());
    }
    for(int i = 0; i < g.length; i++) {
      for(int j = 0; j < g[0].length; j++) {
        if(g[i][j] == true) {
          newGraph.get(i).add(j);
        }
      }
    }
  }
  
  
  public static boolean topologicalSort(ArrayList<Integer> result) {
    int V = newGraph.size();
    int[] visited = new int[V];  
    for(int i = 0; i < V; i++) {
      visited[i] = 0;
    }
    for(int i = 0; i < V; i++) {
      if(visited[i] == 0) {
        boolean x = DFS(i, result, visited);
        if(!x) {
          return false;
        } 
      }
    }
    return true;
  }
  
  public static boolean DFS(int u, ArrayList<Integer> result, int[] visited) {
    visited[u] = 1;
    for(int i = 0; i < newGraph.get(u).size(); i++) {
      int v = newGraph.get(u).get(i);
      if(visited[v] == 0) {
        boolean x = DFS(v, result, visited);
        if(!x) {
          return false;
        }
      } else if(visited[v] == 1) {
        return false;
      }
    }
    result.add(u);
    visited[u] = 2;
    return true;
  }

}
