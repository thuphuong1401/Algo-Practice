/*
https://www.spoj.com/problems/AIBOHP/
*/

import java.util.*;
import java.io.*;

class MyCode {

    // find longest palindromic subsequence (l') => answer is (l - l')
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int lengthLPS = longestPalindromicSequence(s);
        System.out.println(s.length() - lengthLPS);
    }

    private static int longestPalindromicSequence(String s) {
        int n = s.length();
        String revS = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == revS.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }
}
