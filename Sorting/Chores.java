/*
https://codeforces.com/problemset/problem/169/A
*/

import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
   	int a = scan.nextInt();
    int b = scan.nextInt();
    
    int[] chores = new int[n];
    
    for(int i=0; i<n; i++) {
      chores[i] = scan.nextInt();
    }
    
    Arrays.sort(chores);
    
    System.out.println(chores[b] - chores[b-1]);
    
    
  }
}
