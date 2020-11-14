/*
https://www.spoj.com/problems/STPAR/
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
  static final int MAX = 1005;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int[] trucks = new int[MAX];
    Stack<Integer> sideStreet = new Stack<>();
    
    while(true) {
      int n = scan.nextInt();
      if(n == 0) {
        break;
      }
      for(int i = 0; i < n; i++) {
        trucks[i] = scan.nextInt();
      } 
      
      int ordering = 1;
      int i = 0;
      
      while(i < n) {
        // truck == currTruck, let through
        if(trucks[i] == ordering) {
          ordering++;
          i++;
        } 
        else if (!sideStreet.isEmpty() && sideStreet.peek().equals(ordering)) {
        	ordering++;
          sideStreet.pop();
        } 
        else {
          sideStreet.push(trucks[i]);
          i++;
        }
      }
      
      while(!sideStreet.isEmpty() && sideStreet.peek().equals(ordering)) {
        ordering++;
        sideStreet.pop();
      }
     
      if(ordering == n+1) {
        System.out.println("yes");
      } else {
        System.out.println("no");
      }
      sideStreet.clear();
    } 
  }
}
