// package whatever; // don't place package name!

/*
https://www.spoj.com/problems/PRO/cstart=10
*/

import java.io.*;
import java.util.*;

class MyCode {
  
  // prevent polling "polled" elements
  static int big = (int)10e6;
  static boolean[] visited = new boolean[big];
  
	public static void main (String[] args) {
    PriorityQueue<Tuple> pq1 = new PriorityQueue<>(new MinHeapComparator()); // min heap
    PriorityQueue<Tuple> pq2 = new PriorityQueue<>(new MaxHeapComparator()); // max heap
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int id = 0;
    long totalPay = 0;
    for(int i = 0; i < n; i++) {
      int num = scan.nextInt();
      for(int j = 0; j < num; j++) {
        int x = scan.nextInt();
        Tuple containsX = new Tuple(x, id);
        id++;
        pq1.add(containsX);
        pq2.add(containsX);
      }
      
      
      while (visited[pq1.peek().id]) {
        pq1.remove(); // remove all visited elements
      }
      Tuple polled1 = pq1.remove();
      visited[polled1.id] = true;
      
      while(visited[pq2.peek().id]) {
        pq2.remove();
      }
      Tuple polled2 = pq2.remove();
      visited[polled2.id] = true;
      int diff = polled2.value - polled1.value;
      totalPay += diff;
      
    }
    System.out.println(totalPay);
  }
}


class MinHeapComparator implements Comparator<Tuple> {
  @Override
  public int compare(Tuple t1, Tuple t2) {
    if(t1.value < t2.value) {
      return -1; 
    } else if(t1.value == t2.value) {
      return 0;
    } else {
      return 1;
    }
    
  }
}


class MaxHeapComparator implements Comparator<Tuple> {
  @Override
  public int compare(Tuple t1, Tuple t2) {
    if(t1.value < t2.value) {
      return 1; 
    } else if(t1.value == t2.value) {
      return 0;
    } else {
      return -1;
    }
    
  }
}

class Tuple {
  public int value;
  public int id;
  public Tuple(int value, int id) {
    this.value = value;
    this.id = id;
  }
}
