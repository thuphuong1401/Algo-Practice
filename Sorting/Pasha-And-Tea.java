/*
Pasha and Tea: https://codeforces.com/problemset/problem/557/B
*/

import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int w = scan.nextInt();
    int[] cups = new int[2*n];
    for(int i = 0; i < 2*n; i++) {
      cups[i] = scan.nextInt();
    }
    Arrays.sort(cups);
    double girlCap = cups[0];
    double boyCap = cups[n];
    double boyWater = 0;
    double girlWater = 0;
    if((boyCap/2.0) <= girlCap) {
      boyWater = boyCap;
      girlWater = boyCap/2;
    }
    if((boyCap/2.0) > girlCap) {
      boyWater = girlCap * 2;
      girlWater = girlCap;
    }
    //double total = boyWater * n + girlWater * n; 
    double total = 3*girlWater*n;
    if(total > w) {
      total = w;
    }
    System.out.println(total);
  }
}
