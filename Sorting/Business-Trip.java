/*
https://codeforces.com/problemset/problem/149/A
*/

import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int k = scan.nextInt();
    int[] grow = new int[12];
    for(int i = 0; i<12; i++) {
      grow[i] = scan.nextInt();
    }
    
    // flowers must grow >= k centimeters
    Arrays.sort(grow);
    
    int maxGrow = 0;
    for(int j=0; j<grow.length; j++) {
      maxGrow += grow[j];
    }
    
    if(maxGrow < k) {
      System.out.println("-1");
      return;
    }
    
    int numMonths = 0;
    int currLength = 0;
    int i = 11;
    while(currLength < k && i >= 0 & numMonths <= 11) {
      currLength += grow[i];
      numMonths++;
      i--;
    }
    
    System.out.println(numMonths);
    
  }
}
