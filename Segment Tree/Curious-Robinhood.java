/*
https://lightoj.com/problem/curious-robin-hood
*/

import java.util.*;
import java.io.*;

class MyCode {

    static int h;
    static int sizeTree;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scan.nextInt();
            int q = scan.nextInt();

            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scan.nextInt();
            }

            h = (int) Math.ceil(log2(n));
            sizeTree = 2 * (int) Math.pow(2, h) - 1;
            int[] segTree = new int[sizeTree];
            buildTree(arr, segTree, 0, n - 1, 0);

            System.out.println("Case " + i + ":");

            for (int j = 0; j < q; j++) {
                int type = scan.nextInt();
                int u, v;
                if (type == 1) {
                    u = scan.nextInt();
                    System.out.println(arr[u]);
                    updateQuery(segTree, arr, 0, n - 1, 0, u, 0);
                } else if (type == 2) {
                    u = scan.nextInt();
                    v = scan.nextInt();
                    updateQuery(segTree, arr, 0, n - 1, 0, u, arr[u] + v);
                } else {
                    u = scan.nextInt();
                    v = scan.nextInt();
                    int ans = sumRange(segTree, 0, n - 1, u, v, 0);
                    System.out.println(ans);
                }
            }
        }
    }

    private static double log2(int number) {
        return Math.log(number) / Math.log(2);
    }

    private static void buildTree(int[] arr, int[] segTree, int left, int right, int index) {
        if (left == right) {
            segTree[index] = arr[left];
            return;
        }

        int mid = (left + right) / 2;
        buildTree(arr, segTree, left, mid, 2 * index + 1); // left child
        buildTree(arr, segTree, mid + 1, right, 2 * index + 2); // right child
        segTree[index] = segTree[2 * index + 1] + segTree[2 * index + 2];
    }

    private static int sumRange(int[] segTree, int left, int right, int from, int to, int index) {
        if (from <= left && to >= right) {
            return segTree[index];
        }

        if (from > right || to < left) {
            return 0;
        }

        int mid = (left + right) / 2;
        return sumRange(segTree, left, mid, from, to, 2 * index + 1)
                + sumRange(segTree, mid + 1, right, from, to, 2 * index + 2);
    }

    private static void updateQuery(int[] segTree, int[] arr, int left, int right, int index, int pos, int value) {
        if (pos < left || right < pos) {
            return;
        }

        if (left == right) {
            arr[pos] = value;
            segTree[index] = value;
            return;
        }

        int mid = (left + right) / 2;
        if (pos <= mid) {
            updateQuery(segTree, arr, left, mid, 2 * index + 1, pos, value);
        } else {
            updateQuery(segTree, arr, mid + 1, right, 2 * index + 2, pos, value);
        }

        segTree[index] = segTree[2 * index + 1] + segTree[2 * index + 2];
    }

}
