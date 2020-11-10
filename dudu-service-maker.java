// package whatever; // don't place package name!

import java.io.*;
import java.util.*;

class MyCode {
  static ArrayList<ArrayList<Integer>> graph;
  static int n,m,a,b;
  static boolean[] visited; 
  static ArrayList<Integer> path;
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int numTestCases = scan.nextInt();
    for(int l = 0; l < numTestCases; l++) {
      n = scan.nextInt();
      m = scan.nextInt();
      graph = new ArrayList<>(n+1);
      for(int i = 0; i < n+1; i++) {
        graph.add(new ArrayList<Integer>());
      }
      for(int j = 0; j < m ; j++) {
        a = scan.nextInt();
        b = scan.nextInt();
        graph.get(a).add(b);
      }
      visited = new boolean[n+1];
      path = new ArrayList<>();
      for(int k = 0; k < n+1; k++) {
        path.add(-1);
      }
      String answer = null;
      for(int i = 1; i < n+1; i++) {
        answer = DFS(i);
        if(answer.equals("YES")) {
          System.out.println(answer);
          break;
        }
      }
      
      if(answer.equals("YES")) {
        continue;
      }
      
      System.out.println("NO");  
    }
  }
  
  
  public static String DFS(int s) {
    visited[s] = true;
    String answer = "";
    for(int i = 0; i < graph.get(s).size(); i++) {
      // if v not visited => DFS(v)
      // if v visited: is v reachable from s? if yes, return "YES"
      int v = graph.get(s).get(i);
      if(!visited[v]) {
        path.set(v, s);
        DFS(v);
        
      } else {
        /*for (int t = 0; t < n + 1; t++) {
          System.out.printf("%d ", path.get(t));
        }
        System.out.println();
        */
        if (isReachable(v, s)) { 
          // System.out.println("Yo");
          return "YES";
        }
      }
    }
    return "NO";
  }
  
  // check whether there's a path from s to f
  public static boolean isReachable(int s, int f) {
    if(s == f) {
      return true;
    } else {
      if(path.get(f) == -1) {
        return false;
      } else {
        return isReachable(s, path.get(f));
      }
    }
  }
  
  
}
