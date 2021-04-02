/*
https://codeforces.com/problemset/problem/835/D
*/

import java.util.*;
import java.io.*;

public class Main {

    private static int RSHash(String keys) {
        int a = 63689;
        int b = 378551;
        int hashValue = 0;
        for (int i = 0; i < keys.length(); i++) {
            hashValue = (hashValue * a + keys.charAt(i));
            a = a * b;
        }
        return hashValue & 0x7FFFFFFF;
    }

    private static int RSHashReverse(String keys) {
        int a = 63689;
        int b = 378551;
        int hashValue = 0;
        for (int i = keys.length() - 1; i >= 0; i--) {
            hashValue = (hashValue * a + keys.charAt(i));
            a = a * b;
        }
        return hashValue & 0x7FFFFFFF;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        int n = input.length();
        boolean[][][] dp = new boolean[2][n + 1][n + 1];
        int[][] dpSegment = new int[n + 1][n + 1];
        int numKPalindrome = 0;
        int curState = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = input.substring(i, j);
                dpSegment[i][j] = RSHash(sub);
                dp[curState][i][j] = (RSHashReverse(sub) == dpSegment[i][j]);
                if (dp[curState][i][j]) {
                    numKPalindrome++;
                }
            }
        }

        System.out.print(numKPalindrome + " ");

        for (int k = 2; k <= n; k++) {
            numKPalindrome = 0;
            curState = 1 - curState;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (!dp[1 - curState][i][j]) {
                        continue;
                    }
                    int half_len = (j - i) / 2;
                    if (half_len == 0) {
                        dp[curState][i][j] = false;
                    } else if ((dpSegment[i][i + half_len] == dpSegment[j - half_len][j])
                            && dp[1 - curState][i][i + half_len]) {
                        dp[curState][i][j] = true;
                        numKPalindrome++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    dp[1 - curState][i][j] = false;
                }
            }

            System.out.print(numKPalindrome + " ");
        }

        // System.out.println();
        // for(int i = 0; i < n; i++) {
        // for(int j = 0; j < n; j++) {
        // System.out.print(dp[2][i][j] + " ");
        // }
        // System.out.println();
        // }

        /*
         * abacaba 12 4 1 0 0 0 0
         * 
         * dp[k][i][j]: [i, j] co la k-palindrome dp[1][i][j]: True
         * 
         * dp[k][i][j]: 1. Check: nua trai == nua phai? dpSegment[i...(j-i)/2] ==
         * dpSegment[(j-i)/2...j] 2. Check: nua trai co phai k-1 palindome :
         * dp[k-1][i...(j-i)/2] True?
         * 
         * 
         * dpSegment[i][j]: "aba" dpSegment[m][n]:
         * 
         * k = 3 => k-palindome => cong het o chieu k? for(int i = 0; i < n; i+++) {
         * for(int j= i+1; j , N; j++) { res += dp[3][i][j] } }
         * 
         * 
         * aba, bac, ... (5): 2 1-palindrome abca, baca, ..., (4) 5: 1-palindrome 7:
         */

    }
}
