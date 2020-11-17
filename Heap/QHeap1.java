/*
https://www.hackerrank.com/challenges/qheap1/problem
*/

import java.io.*;
import java.util.*;

class MyCode {
  
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int numQueries = scan.nextInt();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    PriorityQueue<Integer> delete = new PriorityQueue<>();
    int query, x;
    for(int i = 0; i < numQueries; i++) {
      query = scan.nextInt();
      if(query == 1) {
        x = scan.nextInt();
        pq.add(x);
      } 
      else if(query == 2) {
        x = scan.nextInt();
        delete.add(x);
      }
      else {
        while(!delete.isEmpty() && (int)pq.peek() == (int)delete.peek()) {
          pq.remove();
          delete.remove();
        }
        System.out.println(pq.peek());
      }
      
    }
  
  }
}
