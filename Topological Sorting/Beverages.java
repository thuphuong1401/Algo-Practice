// package whatever; // don't place package name!
/*
https://vjudge.net/problem/UVA-11060
*/


import java.io.*;
import java.util.*;


class MyCode {
  static ArrayList<ArrayList<Integer>> graph;
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int counter = 1;
    while(scan.hasNext()) {
      int n = scan.nextInt();
      String[] beverages = new String[n];
      for(int i = 0; i < n; i++) {
        beverages[i] = scan.next();
      }
      int m = scan.nextInt();
      graph = new ArrayList<>(n);
      for(int i = 0; i < n; i++) {
        graph.add(new ArrayList<Integer>());  
      }
      for(int i = 0; i < m; i++) {
        String s1 = scan.next();
        String s2 = scan.next();
        int u = getCode(beverages, s1);
        int v = getCode(beverages, s2);
        graph.get(u).add(v);
      }
      
      ArrayList<Integer> result = new ArrayList<>();
      topologicalSort(result);
      
      System.out.print("Case #" + counter + ": Dilbert should drink beverages in this order:");
      for(int i : result) {
        System.out.print(" " + beverages[i]);
      }
      System.out.print(".");
      System.out.println();
      System.out.println();
      
      counter++;
    }
    
  }
  
  public static boolean topologicalSort(ArrayList<Integer> result) {
    int V = graph.size();
    int[] indegree = new int[V];
    PriorityQueue<Integer> zeroIndegree = new PriorityQueue<>();
    for(int u = 0; u < V; u++) {
      for(int v : graph.get(u)) {
        indegree[v]++;
      }
    }
    for(int i = 0; i < V; i++) {
      if(indegree[i] == 0) {
        zeroIndegree.add(i);
      }
    }
    
    while(!zeroIndegree.isEmpty()) {
      int u = zeroIndegree.poll();
      result.add(u);
      for(int v : graph.get(u)) {
        indegree[v]--;
        if(indegree[v] == 0) {
          zeroIndegree.add(v);
        }
      }
    }
    
    for(int i = 0; i < V; i++) {
      if(indegree[i] != 0) {
        return false;
      }
    }
    return true;
  }
  
  
  
  public static int getCode(String[] arr, String s) {
    int index = -1;
    for(int i = 0; i < arr.length; i++) {
      if(arr[i].equals(s)) {
        index = i;
        break;
      }
    }
    return index;
  }
  
}
