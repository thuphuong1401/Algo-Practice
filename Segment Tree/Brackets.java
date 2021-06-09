/*
https://www.spoj.com/problems/BRCKTS/
*/
import java.io.*;
import java.util.*;

class MyCode {

  static int n;
  static String s;
  static final int N = 30009;
  static segTreeNode[] segTree;

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

  static class segTreeNode {

    int open; // num opening brackets
    int close; // num closing brackets
    int match; // num matched brackets

    public segTreeNode(int open, int close, int match) {
      this.open = open;
      this.close = close;
      this.match = match;
    }
  }

  // based on 2 children, calculate the parent node
  private static segTreeNode calculate(segTreeNode left, segTreeNode right) {
    int numOpen = left.open + right.open;
    int numClose = left.close + right.close;
    // how many brackets will the "leftovers" of left children and right children create?
    int numMatch =
      Math.min(left.open - left.match, right.close - right.match) +
      left.match +
      right.match;
    segTreeNode newNode = new segTreeNode(numOpen, numClose, numMatch);
    return newNode;
  }

  /*
    Side note: really think about how to make parent nodes out of left and right child
    */
  static void buildTree(int left, int right, int index) {
    if (left == right) {
      if (s.charAt(left) == ')') {
        segTree[index] = new segTreeNode(0, 1, 0);
      } else {
        segTree[index] = new segTreeNode(1, 0, 0);
      }
      return;
    }

    int mid = left + (right - left) / 2;
    buildTree(left, mid, 2 * index + 1);
    buildTree(mid + 1, right, 2 * index + 2);

    segTree[index] = calculate(segTree[2 * index + 1], segTree[2 * index + 2]);
  }

  static void updateTree(int left, int right, int pos, int index) {
    if (pos < left || right < pos) {
      return;
    }

    if (left == right) {
      if (segTree[index].close == 1) {
        segTree[index] = new segTreeNode(1, 0, 0);
      } else {
        segTree[index] = new segTreeNode(0, 1, 0);
      }
      return;
    }

    int mid = left + (right - left) / 2;

    updateTree(left, mid, pos, 2 * index + 1);
    updateTree(mid + 1, right, pos, 2 * index + 2);

    segTree[index] = calculate(segTree[2 * index + 1], segTree[2 * index + 2]);
  }

  public static void main(String[] args) throws IOException {
    FastReader sc = new FastReader(System.in);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int t = 1; t <= 10; t++) {
      n = sc.nextInt();
      s = sc.next();
      segTree = new segTreeNode[4 * n];
      buildTree(0, n - 1, 0);
      int m = sc.nextInt();
      out.write("Test " + t + ":\n");
      for (int i = 0; i < m; i++) {
        int k = sc.nextInt();
        if (k == 0) {
          if (segTree[0].match == n / 2 && n % 2 == 0) {
            out.write("YES\n");
          } else {
            out.write("NO\n");
          }
        } else {
          updateTree(0, n - 1, k - 1, 0);
        }
      }
    }

    out.close();
  }
}
