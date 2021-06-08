/*
https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=3977
*/

import java.io.*;
import java.util.*;

class MyCode {

  static int[] arr;
  static int[] segTree;
  static int n, k;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    while (scan.hasNext()) {
      n = scan.nextInt();
      k = scan.nextInt();
      arr = new int[n];
      int h = (int) Math.ceil(log2(n));
      int sizeTree = 2 * (int) Math.pow(2, h) - 1;
      segTree = new int[sizeTree];
      Arrays.fill(segTree, 1);
      for (int i = 0; i < n; i++) {
        arr[i] = scan.nextInt();
      }
      buildTree(0, n - 1, 0);
      for (int i = 0; i < k; i++) {
        String type = scan.next();
        int l = scan.nextInt();
        int r = scan.nextInt();
        if (type.equals("C")) {
          l--;
          updateQuery(0, n - 1, 0, l, r);
        } else {
          l--;
          r--;
          int ans = productQuery(0, n - 1, l, r, 0);
          char printAns;
          if (ans == 0) {
            printAns = '0';
          } else if (ans > 0) {
            printAns = '+';
          } else {
            printAns = '-';
          }
          System.out.print(printAns);
        }
      }
      System.out.println();
    }
  }

  private static double log2(int number) {
    return Math.log(number) / Math.log(2);
  }

  private static void buildTree(int left, int right, int index) {
    if (left == right) {
      if (arr[left] > 0) {
        segTree[index] = 1;
      } else if (arr[left] < 0) {
        segTree[index] = -1;
      } else {
        segTree[index] = 0;
      }
      return;
    }

    int mid = left + (right - left) / 2;
    buildTree(left, mid, 2 * index + 1);
    buildTree(mid + 1, right, 2 * index + 2);

    segTree[index] = segTree[2 * index + 1] * segTree[2 * index + 2];
  }

  private static void updateQuery(
    int left,
    int right,
    int index,
    int pos,
    int value
  ) {
    if (pos < left || right < pos) {
      return;
    }

    if (left == right) {
      arr[pos] = value;
      if (value == 0) {
        segTree[index] = 0;
      } else if (value > 0) {
        segTree[index] = 1;
      } else {
        segTree[index] = -1;
      }
      return;
    }

    int mid = left + (right - left) / 2;
    if (pos <= mid) {
      updateQuery(left, mid, 2 * index + 1, pos, value);
    } else {
      updateQuery(mid + 1, right, 2 * index + 2, pos, value);
    }

    segTree[index] = segTree[2 * index + 1] * segTree[2 * index + 2];
  }

  private static int productQuery(
    int left,
    int right,
    int from,
    int to,
    int index
  ) {
    if (from <= left && right <= to) {
      return segTree[index];
    }
    if (from > right || to < left) {
      return 1;
    }

    int mid = left + (right - left) / 2;
    return (
      productQuery(left, mid, from, to, 2 * index + 1) *
      productQuery(mid + 1, right, from, to, 2 * index + 2)
    );
  }
}
