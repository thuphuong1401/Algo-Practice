/*
https://codeforces.com/problemset/problem/514/C
*/
import java.io.*;
import java.util.*;

class MyCode {

  static long POW[][];
  static long base = 119;
  static long[] MOD = { (long) 1e9 + 7, (long) 1e9 + 9 };
  static int MAX = (int) 1e6 + 1;
  static int n, m;

  private static void calculatePOW() {
    POW = new long[2][MAX];
    POW[0][0] = 1;
    POW[1][0] = 1;
    for (int i = 1; i < MAX; i++) {
      POW[0][i] = (POW[0][i - 1] * base) % MOD[0];
      POW[1][i] = (POW[1][i - 1] * base) % MOD[1];
    }
  }

  private static long[] createHash(String s) {
    int l = s.length();
    long[] hashValue = new long[2];
    for (int i = 0; i < l; i++) {
      hashValue[0] = (hashValue[0] * base + s.charAt(i) - 'a' + 1) % MOD[0];
      hashValue[1] = (hashValue[1] * base + s.charAt(i) - 'a' + 1) % MOD[1];
    }
    return hashValue;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    m = scan.nextInt();
    calculatePOW();
    Set<Long> set1 = new HashSet<>();
    Set<Long> set2 = new HashSet<>();
    while (n-- > 0) {
      String s = scan.next();
      int l = s.length();
      long[] hashedS = createHash(s);
      for (int i = 0; i < l; i++) {
        for (int c = 97; c <= 99; c++) {
          if (s.charAt(i) == (char) c) {
            continue;
          }
          long[] hashDiff = new long[2];
          hashDiff[0] =
            (
              hashedS[0] +
              ((c - s.charAt(i)) * POW[0][l - i - 1]) %
              MOD[0] +
              MOD[0]
            ) %
            MOD[0];
          hashDiff[1] =
            (
              hashedS[1] +
              ((c - s.charAt(i)) * POW[1][l - i - 1]) %
              MOD[1] +
              MOD[1]
            ) %
            MOD[1];
          set1.add(hashDiff[0]);
          set2.add(hashDiff[1]);
          //long hashDiff = hashedS - ((s.charAt(i) - 'a' + 1) * POW[l-i-1]) % MOD + ((c - 97 + 1) * POW[l-i-1]) % MOD;
        }
      }
    }

    while (m-- > 0) {
      String str = scan.next();
      long[] hashedStr = createHash(str);
      if (set1.contains(hashedStr[0]) && set2.contains(hashedStr[1])) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}
