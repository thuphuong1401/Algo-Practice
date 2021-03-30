/*
https://www.geeksforgeeks.org/lcs-longest-common-subsequence-three-strings/
*/

import java.util.*;
import java.io.*;

class MyCode {
    static int n, m, l;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        while (numTestCases-- > 0) {
            n = scan.nextInt();
            m = scan.nextInt();
            l = scan.nextInt();
            String s1 = scan.next();
            String s2 = scan.next();
            String s3 = scan.next();
            int ans = LCSThreeStrings(s1, s2, s3);
            System.out.println(ans);
        }
    }

    private static int LCSThreeStrings(String s1, String s2, String s3) {
        int[][][] dp = new int[n + 1][m + 1][l + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= l; k++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1) && s2.charAt(j - 1) == s3.charAt(k - 1)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                    }
                }
            }
        }
        return dp[n][m][l];
    }

}
