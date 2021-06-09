/*
https://codeforces.com/problemset/problem/52/C
*/

import java.io.*;
import java.util.*;

public class Main {

  static int[] arr;
  static long[] segTree;
  static long[] lazy;
  static int n;
  static int h;
  static long INF = (long) 1e18;

  static class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader(InputStream in) {
      br = new BufferedReader(new InputStreamReader(in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }

  private static double log2(int number) {
    return Math.log(number) / Math.log(2);
  }

  private static void buildTree(int left, int right, int index) {
    if (left == right) {
      segTree[index] = arr[left];
      return;
    }

    int mid = left + (right - left) / 2;
    buildTree(left, mid, 2 * index + 1);
    buildTree(mid + 1, right, 2 * index + 2);

    segTree[index] = Math.min(segTree[2 * index + 1], segTree[2 * index + 2]);
  }

  private static void updateRangeLazy(
    int left,
    int right,
    int from,
    int to,
    long delta,
    int index
  ) {
    if (left > right) {
      return;
    }

    if (lazy[index] != 0) {
      segTree[index] += lazy[index];
      if (left != right) {
        lazy[2 * index + 1] += lazy[index];
        lazy[2 * index + 2] += lazy[index];
      }
      lazy[index] = 0;
    }

    // no overlap
    if (from > right || to < left) {
      return;
    }

    // total overlap
    if (from <= left && right <= to) {
      segTree[index] += delta;
      if (left != right) {
        lazy[2 * index + 1] += delta;
        lazy[2 * index + 2] += delta;
      }
      return;
    }

    // partial overlap => look both left and right
    int mid = left + (right - left) / 2;
    updateRangeLazy(left, mid, from, to, delta, 2 * index + 1);
    updateRangeLazy(mid + 1, right, from, to, delta, 2 * index + 2);
    segTree[index] = Math.min(segTree[2 * index + 1], segTree[2 * index + 2]);
  }

  private static long minRangeLazy(
    int left,
    int right,
    int from,
    int to,
    int index
  ) {
    if (left > right) {
      return INF;
    }

    if (lazy[index] != 0) {
      segTree[index] += lazy[index];
      if (left != right) {
        lazy[2 * index + 1] += lazy[index];
        lazy[2 * index + 2] += lazy[index];
      }
      lazy[index] = 0;
    }

    // no overlap
    if (from > right || to < left) {
      return INF;
    }

    // total overlap
    if (from <= left && right <= to) {
      return segTree[index];
    }

    // partial overlap
    int mid = left + (right - left) / 2;
    return Math.min(
      minRangeLazy(left, mid, from, to, 2 * index + 1),
      minRangeLazy(mid + 1, right, from, to, 2 * index + 2)
    );
  }

  public static void main(String[] args) throws IOException {
    FastReader scan = new FastReader(System.in);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    n = scan.nextInt();
    arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scan.nextInt();
    }

    int h = (int) Math.ceil(log2(n));
    int sizeTree = 2 * (int) Math.pow(2, h) - 1;
    segTree = new long[sizeTree];
    lazy = new long[sizeTree];
    buildTree(0, n - 1, 0);

    int m = scan.nextInt();
    for (int i = 0; i < m; i++) {
      int lf = 0, rg = 0;
      long v = INF;
      String inp = scan.nextLine();
      String[] temp = inp.split(" ");
      lf = Integer.parseInt(temp[0]);
      rg = Integer.parseInt(temp[1]);
      if (temp.length == 3) {
        v = (long) Integer.parseInt(temp[2]);
      }

      if (v == INF) {
        long ans = 0;
        if (lf > rg) {
          ans =
            Math.min(
              minRangeLazy(0, n - 1, lf, n - 1, 0),
              minRangeLazy(0, n - 1, 0, rg, 0)
            );
        } else {
          ans = minRangeLazy(0, n - 1, lf, rg, 0);
        }
        out.write(ans + "\n");
      } else { // update-able
        if (lf > rg) {
          updateRangeLazy(0, n - 1, lf, n - 1, v, 0);
          updateRangeLazy(0, n - 1, 0, rg, v, 0);
        } else {
          updateRangeLazy(0, n - 1, lf, rg, v, 0);
        }
      }
    }

    out.close();
  }
}
