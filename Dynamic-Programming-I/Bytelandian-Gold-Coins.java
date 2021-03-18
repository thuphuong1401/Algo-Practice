/*
https://www.spoj.com/problems/COINS/
*/

import java.util.*;
import java.io.*;

class MyCode {
	static int MAX = (int)1e6 + 1;
    static long dp[];
    
    public static void main (String[] args) {
        dp = new long[MAX];
        Arrays.fill(dp, -1);
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()) {
            int n = scan.nextInt();
            long ans = maxUSD(n);
            System.out.println(ans);
        }
	}
    
    private static long maxUSD(int n) {
        if(n < 3) {
            return n;
        }
        if(n < MAX && dp[n] != -1) {
            return dp[n];
        } 
        long firstChoice = maxUSD(n/2) + maxUSD(n/3) + maxUSD(n/4);
        long res = Math.max(firstChoice, n);
        if(n < MAX) {
            dp[n] = res;
        }
        return res;
    }
    
}


