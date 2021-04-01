/*
https://codeforces.com/problemset/problem/835/D
*/
import java.util.*;
import java.io.*;

class MyCode {
    
    private static boolean isPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return s.equals(rev);
    }
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        int n = input.length();
        boolean[][][] dp = new boolean[n+1][n+1][n+1];
        String[][] dpSegment = new String[n+1][n+1];
        int numKPalindrome = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j <= n; j++) {
                dpSegment[i][j] = input.substring(i, j);
                dp[1][i][j] = isPalindrome(dpSegment[i][j]);
                if (dp[1][i][j]) {
                    numKPalindrome++;
                }
            }
        }
        
        System.out.print(numKPalindrome + " ");
        
        for(int k = 2; k <= n; k++) {
            numKPalindrome = 0;
            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j <= n; j++) {
                    
                    int half_len = (j - i) / 2;
                    if(half_len == 0) {
                        dp[k][i][j] = false;
                        continue;
                    }
                    if(dpSegment[i][i + half_len].equals(dpSegment[j - half_len][j]) && dp[k-1][i][i + half_len]) {
                        dp[k][i][j] = true;
                        numKPalindrome++;
                    }
                }
            }
            System.out.print(numKPalindrome + " ");
        }
        
        
        // System.out.println();
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.print(dp[2][i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        
        /*abacaba
        12 4 1 0 0 0 0 
        
        dp[k][i][j]: [i, j] co la k-palindrome
        dp[1][i][j]: True
        
        dp[k][i][j]: 
        1. Check: nua trai == nua phai? dpSegment[i...(j-i)/2] == dpSegment[(j-i)/2...j]
        2. Check: nua trai co phai k-1 palindome : dp[k-1][i...(j-i)/2] True?
        
        
        dpSegment[i][j]: "aba"
        dpSegment[m][n]: 
        
        k = 3 => k-palindome => cong het o chieu k?
        for(int i = 0; i < n; i+++) {
            for(int j= i+1; j , N; j++) {
                res += dp[3][i][j]
            }
        }
        
        
        aba, bac, ... (5): 2 1-palindrome
        abca, baca, ..., (4)
        5: 1-palindrome
        7: 
        */

	}
}

