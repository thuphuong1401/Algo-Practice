/*
https://www.codechef.com/MAY14/problems/COMPILER
*/ 

import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    while(scan.hasNext()) {
      String line = scan.next();
      char[] exp = line.toCharArray();
      
      
      Stack<Character> s = new Stack<>();
      int prefixLength = 0;
      
      if(exp[0] == '>') {
        System.out.println("0");
        continue;
      }
      
      for(int j = 0; j < exp.length; j++) {
      	if(exp[j] == '<') {
          s.push(exp[j]);
        } 
        else if(s.isEmpty()) {
          break;
        }
       	else {
          s.pop();
          prefixLength = (s.isEmpty() ?  j+1 : prefixLength); //smart
        }  
      }
      System.out.println(prefixLength);
    }
  }
}
