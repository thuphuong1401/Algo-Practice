/*
https://codeforces.com/problemset/problem/6/C
*/

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] chocolate = new int[n];
    for(int i=0; i<n; i++) {
      chocolate[i] = scan.nextInt();
    }
    
    int aliceTime = 0;
    int bobTime = 0;
    int i = 0, j = n-1;
    
    while(i<=j) {
      if(aliceTime + chocolate[i] <= bobTime + chocolate[j]) {
        aliceTime += chocolate[i];
        i++;
      } else {
        bobTime += chocolate[j];
        j--;
      }
    }
    System.out.println(i + " " + (n-i));
  }
}
