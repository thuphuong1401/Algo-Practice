/*
https://codeforces.com/problemset/problem/731/A
*/

import java.util.Scanner;
import java.lang.Math;

public class nightAtTheMuseum {
	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    int minRotation = 0;
    
    if ((int)input.charAt(0) == 97) {
      minRotation = 0;
    } else {
      int firstDiff = Math.abs(97 - (int) input.charAt(0));
      int firstReverseDiff = 26 - firstDiff;
      if (firstDiff <= firstReverseDiff) {
        minRotation += firstDiff;
      } else {
        minRotation += firstReverseDiff;
      }
    }
    
    for (int i = 0; i < input.length()-1; i++) {
      int c = (int) input.charAt(i);
      int d = (int) input.charAt(i+1);
      
      // Cases:
      int diff = Math.abs(c - d);
      int reverseDiff = 26 - diff;
      if (diff <= reverseDiff) {
        minRotation += diff;
      } else {
        minRotation += reverseDiff;
      }
    }
 		System.out.println(minRotation);  
  }
}
