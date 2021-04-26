/*
https://www.spoj.com/problems/SAMER08D/
*/

import java.util.*;
import java.io.*;

class MyCode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int k = scan.nextInt();
            if (k == 0) {
                break;
            }
            String temp1 = scan.next();
            String temp2 = scan.next();
            int m = temp1.length();
            int n = temp2.length();
            String a = " " + temp1;
            String b = " " + temp2;
            int[][] dp = new int[m + 1][n + 1];
            int[][] f = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (a.charAt(i) == b.charAt(j)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                    for (int l = k; l <= dp[i][j]; l++) {
                        f[i][j] = Math.max(f[i][j], f[i - l][j - l] + l);
                    }
                }
            }
            System.out.println(f[m][n]);
        }
    }
}
