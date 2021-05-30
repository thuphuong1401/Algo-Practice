/*
https://codeforces.com/problemset/problem/1137/B
*/
import java.io.*;
import java.util.*;

class MyCode {

  static long MOD = (long) 1e9 + 7;
  static int MAX = (int) 5e5;
  static long base = 29;
  static long POW[];
  static long hashT[];

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = scan.next();
    String t = scan.next();
    int n = s.length();
    int m = t.length();
    if (m > n) {
      System.out.println(s);
      return;
    }
    POW = new long[MAX + 1];
    POW[0] = 1;
    for (int i = 1; i <= MAX; i++) {
      POW[i] = (POW[i - 1] * base) % MOD;
    }
    createHash(t);
    int maxPrefixDuplicate = 0; // length of longest overlap between prefix and suffix
    for (int i = m - 1; i > 0; i--) {
      if (getHash(1, i) == getHash(m - i + 1, m)) {
        maxPrefixDuplicate = i;
        break;
      }
    }
    int cntSZeros = 0;
    int cntSOnes = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) - '0' == 0) {
        cntSZeros++;
      }
    }
    cntSOnes = n - cntSZeros;

    for (int i = 0; i < m; i++) {
      if (t.charAt(i) == '0') {
        cntSZeros--;
      } else {
        cntSOnes--;
      }
    }

    if (cntSZeros < 0 || cntSOnes < 0) {
      System.out.println(s);
      return;
    }

    StringBuilder ans = new StringBuilder(t);

    t = t.substring(maxPrefixDuplicate, m);

    int cntTZeros = 0;
    int cntTOnes = 0;
    for (int i = 0; i < t.length(); i++) {
      if (t.charAt(i) - '0' == 0) {
        cntTZeros++;
      }
    }
    cntTOnes = t.length() - cntTZeros;
    while (cntSZeros - cntTZeros >= 0 && cntSOnes - cntTOnes >= 0) {
      ans.append(t);
      cntSZeros -= cntTZeros;
      cntSOnes -= cntTOnes;
      //System.out.println(ans.toString() + " " + cntSZeros + " " + cntSOnes + " " + cntTZeros + " " + cntTOnes);
    }

    while (cntSZeros > 0) {
      ans.append('0');
      cntSZeros--;
    }

    while (cntSOnes > 0) {
      ans.append('1');
      cntSOnes--;
    }

    System.out.println(ans.toString());
  }

  private static void createHash(String t) {
    int m = t.length();
    hashT = new long[m + 1];
    long hashValue = 0;
    for (int i = 1; i <= m; i++) {
      hashValue = hashValue * base + t.charAt(i - 1) - '0' + 1;
      hashValue %= MOD;
      hashT[i] = hashValue;
    }
  }

  private static long getHash(int l, int r) {
    return (hashT[r] - (hashT[l - 1] * POW[r - l + 1]) % MOD + MOD) % MOD;
  }
}
