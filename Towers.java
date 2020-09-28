/*
https://codeforces.com/problemset/problem/37/A
Without sorting
*/

import java.util.Scanner; 
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] length = new int[n];
    for(int i = 0; i < n; i++) {
      length[i] = scan.nextInt();
    }
    int[] towers = new int[1001];
    for(int i = 0; i < n; i++) {
      towers[length[i]] += 1;
    }
    int maxHeight = towers[0];
    int numTowers = 0;
    for(int i = 0; i < towers.length; i++) {
      maxHeight = Math.max(maxHeight, towers[i]);
      if(towers[i] != 0) {
        numTowers += 1;
      }
    }
    System.out.println(maxHeight + " " + numTowers);
  }
}
