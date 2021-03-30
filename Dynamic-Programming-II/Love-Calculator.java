/*
https://lightoj.com/problem/love-calculator
*/
import java.util.*;
import java.io.*;

class MyCode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        for (int i = 1; i <= numTestCases; i++) {
            String s1 = scan.next();
            String s2 = scan.next();
            System.out.print("Case " + i + ": ");
            shortestSuperSequence(s1, s2);
        }
    }

    private static void shortestSuperSequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        long[][] dp = new long[n + 1][m + 1];
        long[][] dpNumWays = new long[n + 1][m + 1];

        dpNumWays[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
            dpNumWays[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            dp[0][i] = i;
            dpNumWays[0][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    dpNumWays[i][j] = dpNumWays[i - 1][j - 1];
                } else {
                    if (dp[i - 1][j] < dp[i][j - 1]) {
                        dp[i][j] = dp[i - 1][j] + 1;
                        dpNumWays[i][j] = dpNumWays[i - 1][j];
                    } else if (dp[i - 1][j] > dp[i][j - 1]) {
                        dp[i][j] = dp[i][j - 1] + 1;
                        dpNumWays[i][j] = dpNumWays[i][j - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j] + 1; // cdg cung dc
                        dpNumWays[i][j] = dpNumWays[i - 1][j] + dpNumWays[i][j - 1];
                    }
                }
            }
        }

        System.out.print(dp[n][m] + " " + dpNumWays[n][m]);
        System.out.println();
    }
}
