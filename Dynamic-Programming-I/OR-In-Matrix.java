/*
https://codeforces.com/problemset/problem/486/B
*/
import java.util.*;
import java.io.*;

class MyCode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] B = new int[m][n];
        int[][] A = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = scan.nextInt();
                A[i][j] = 1;
            }
        }

        // fill 0's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (B[i][j] == 0) {
                    for (int k = 0; k < n; k++) {
                        A[i][k] = 0;
                    }
                    for (int k = 0; k < m; k++) {
                        A[k][j] = 0;
                    }
                }
            }
        }

        // generate A to B
        int[] rowOR = new int[m];
        int[] colOR = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowOR[i] |= A[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                colOR[i] |= A[j][i];
            }
        }

        // generate B
        boolean flag = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = rowOR[i] | colOR[j];
                if (curr != B[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        if (!flag) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(A[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
