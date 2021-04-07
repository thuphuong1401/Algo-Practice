/*
https://www.spoj.com/problems/ADFRUITS
Big idea: find shortest common sequence based on LCS
*/

import java.util.*;
import java.io.*;

class MyCode {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            if (!scan.hasNext()) {
                return;
            }

            String a = scan.next();
            String b = scan.next();

            String ans = shortestSuperseq(a, b);
            System.out.println(ans);
        }
    }

    private static String shortestSuperseq(String a, String b) {
        int m = a.length();
        int n = b.length();
        a = "#" + a;
        b = "#" + b;
        int[][] dp = new int[m + 1][n + 1];

        // find lcs(a,b)
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // find superseq(a,b) based on lcs(a,b)
        // superseq(a,b): all letters of a & b, but letters in lcs(a,b) only appear once
        StringBuilder ans = new StringBuilder();
        int i = m;
        int j = n;
        while (i > 0 || j > 0) {
            if (i == 0) {
                ans.append(b.charAt(j));
                j--;
            } else if (j == 0) {
                ans.append(a.charAt(i));
                i--;
            } else {
                if (a.charAt(i) == b.charAt(j)) {
                    ans.append(a.charAt(i));
                    i--;
                    j--;
                } else if (dp[i][j] == dp[i - 1][j]) {
                    ans.append(a.charAt(i));
                    i--;
                } else {
                    ans.append(b.charAt(j));
                    j--;
                }
            }
        }
        return ans.reverse().toString();
    }

}
