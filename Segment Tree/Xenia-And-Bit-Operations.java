/*
https://codeforces.com/problemset/problem/339/D
*/
import java.io.*;
import java.util.*;

public class Main {

  static int[] arr;
  static int[] segTree;
  static int n;
  static int h;

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

  private static void buildTree(int left, int right, int index, int level) {
    if (left == right) {
      segTree[index] = arr[left];
      return;
    }

    int mid = left + (right - left) / 2;
    buildTree(left, mid, 2 * index + 1, level - 1);
    buildTree(mid + 1, right, 2 * index + 2, level - 1);

    if (level % 2 == 0) {
      segTree[index] = (segTree[2 * index + 1] ^ segTree[2 * index + 2]);
    } else {
      segTree[index] = (segTree[2 * index + 1] | segTree[2 * index + 2]);
    }
  }

  private static void update(
    int left,
    int right,
    int index,
    int pos,
    int value,
    int level
  ) {
    if (left > pos || right < pos) {
      return;
    }

    if (left == right) {
      arr[pos] = value;
      segTree[index] = value;
      return;
    }

    int mid = left + (right - left) / 2;
    if (pos <= mid) {
      update(left, mid, 2 * index + 1, pos, value, level - 1);
    } else {
      update(mid + 1, right, 2 * index + 2, pos, value, level - 1);
    }

    if (level % 2 == 0) {
      segTree[index] = segTree[2 * index + 1] ^ segTree[2 * index + 2];
    } else {
      segTree[index] = segTree[2 * index + 1] | segTree[2 * index + 2];
    }
  }

  public static void main(String[] args) throws IOException {
    FastReader scan = new FastReader(System.in);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    n = scan.nextInt();
    int m = scan.nextInt();
    int size = 1 << n;
    arr = new int[1 << n];
    for (int i = 0; i < size; i++) {
      arr[i] = scan.nextInt();
    }

    h = (int) Math.ceil(log2(size)); // h = 2 for n = 2
    int sizeTree = 2 * (int) Math.pow(2, h) - 1;
    segTree = new int[sizeTree];
    buildTree(0, size - 1, 0, h);

    for (int i = 0; i < m; i++) {
      int p = scan.nextInt() - 1;
      int b = scan.nextInt();
      update(0, size - 1, 0, p, b, h);
      out.write(segTree[0] + "\n");
      /*
      for(int j = 0; j < sizeTree; j++) {
        System.out.print(segTree[j] + " ");
      }
      */

    }
    out.close();
  }
}
