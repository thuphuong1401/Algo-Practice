/*
https://codeforces.com/problemset/problem/271/D#
*/
import java.io.*;
import java.util.*;

class MyCode {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = scan.next();
    String b = scan.next();
    int k = scan.nextInt();
    Set<Long> set = new HashSet<>();
    long base = 33;
    int n = s.length();
    for (int i = 0; i < n; i++) {
      int numBad = 0;
      long hashValue = 0;
      for (int j = i; j < n; j++) {
        int currChar = s.charAt(j) - 'a';
        hashValue = hashValue * base + currChar + 1; // polynomial hash
        if (b.charAt(currChar) == '0') {
          numBad++;
        }
        if (numBad > k) {
          break;
        } else {
          set.add(hashValue);
        }
      }
    }
    System.out.println(set.size());
  }
}
