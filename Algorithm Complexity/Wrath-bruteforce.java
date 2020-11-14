/*
https://codeforces.com/problemset/problem/892/B
*/

import java.util.Scanner;

// Wrath - Codeforces - The bruteforce way

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] claw = new int[n];
    for(int i=0; i<n; i++) {
      claw[i] = scan.nextInt();
    }
    boolean[] killed = new boolean[n];
   
    // find what j is killed by i
    for(int i=1; i<n; i++) {
      int j = i-1;
 			while(j>=0)	{
        if(killed[j] == false && j<i && j>= i-claw[i]) {
          killed[j] = true;
        }
        j--;
      }
    }
    
    int alive = 0;
    for(int i=0; i<n; i++) {
    	if(killed[i] == false) {
        alive++;
      }  
    }
    System.out.println(alive);
  } 
}
