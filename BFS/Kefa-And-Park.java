// package whatever; // don't place package name!
/*
https://codeforces.com/problemset/problem/580/C
*/
import java.io.*;
import java.util.*;

class MyCode {
   static int N, M;
   static int MAX = 100005;
   static int[] cat = new int[MAX]; // cat[i]: number of consecutive cats from start to vertex i
   static int[] arr = new int[MAX]; // arr[i]: this vertex contains cat or not
   static ArrayList<ArrayList<Integer>> graph;
   static int numRestaurant = 0;
   
   public static void main(String[] args) {
     
     Scanner scan = new Scanner(System.in);
     N = scan.nextInt();
     M = scan.nextInt();
     
     for(int i = 1; i < N+1; i++) {
       arr[i] = scan.nextInt();
     }
     
     graph = new ArrayList<>(N+1);
     
     for(int i = 0; i < N+1; i++) {
       graph.add(new ArrayList<Integer>());
     }
     
     for(int j = 0; j < N-1; j++) {
       int u = scan.nextInt();
       int v = scan.nextInt();
       graph.get(u).add(v);
       graph.get(v).add(u);
     }
     
     BFS(1);
     System.out.println(numRestaurant);
     
   }
   
   public static void BFS(int s) {
     Queue<Integer> queue = new LinkedList<>();
     boolean[] visited = new boolean[MAX];
     
     queue.add(s);
     visited[s] = true;
     
     if(arr[s] == 0) {
       cat[s] = 0;
     } else {
       cat[s] = 1; 
     }
     
     while(!queue.isEmpty()) {
       int u = queue.remove();
       for(int i = 0; i < graph.get(u).size(); i++) {
         int v = graph.get(u).get(i);
         if(!visited[v]) {
            visited[v] = true;
            if(arr[v] == 1) {
              cat[v] = cat[u] + 1;
            } 
            if(cat[v] <= M) {
              if(graph.get(v).size() == 1) {
                numRestaurant++;
              } else {
                queue.add(v);
            } 
                   
            }
         }
       }
     }
   }
}
