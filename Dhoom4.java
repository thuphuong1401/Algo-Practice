// package whatever; // don't place package name!

import java.io.*;
import java.util.*;

class MyCode {
  static int MAX = 100009;
  static int[] dist; // distance from source to any other node
  static int[] keys;
  static int N;
  
  public static int BFS(int s, int f) {
    dist = new int[MAX];
    for(int i = 0; i < MAX; i++) {
      dist[i] = -1; 
    }
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);
    dist[s] = 0;
    
    while(!queue.isEmpty()) {
      int u = queue.remove();
      
      for(int i = 0; i < N; i++) {
        Long temp = (1L * u * keys[i]) % 100000; // create a new node
        int v = temp.intValue();
        
        if(dist[v] == -1) { // v hasn't been "visited"
          dist[v] = dist[u] + 1;
          queue.add(v);
        }
        
        if(v == f) {
          return dist[v];
        } 
        
      }
    }
    
    return -1;
    
  }
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int s = scan.nextInt();
    int f = scan.nextInt();
    N = scan.nextInt();
    keys = new int[MAX];
    for(int i = 0; i < N; i++) {
        keys[i] = scan.nextInt();
    }
    
    System.out.println(BFS(s, f));
    
  }        
}

