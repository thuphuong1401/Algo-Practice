// package whatever; // don't place package name!
/*
https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/practice-problems/algorithm/monk-and-multiplication/
*/

import java.io.*;
import java.util.*;

class MyCode {
	
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for(int i = 0; i < n; i++) {
      int x = scan.nextInt();
      pq.add(x);
      if(i == 0 || i == 1) {
        System.out.println(-1);
        continue;
      }
      int first = pq.poll();
      int second = pq.poll();
      int third = pq.poll();
      long product = 1L * first * second * third;
      System.out.println(product);
      
      pq.add(first);
      pq.add(second);
      pq.add(third);

    }
    
    
    
    
	}
}



