/*
https://www.nguyentheanh.com/to-hop-lap/
https://lightoj.com/problem/problem-makes-problem
*/
import java.util.*;
import java.io.*;

class MyCode {

    static final long INF = (int)1e9 + 7;
    static final int MAX = (int)2e6 + 5;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        long[] dp = new long[MAX];
        dp[0] = 1;
        dp[1] = 1;
        long nFactorial = 1;
        for(int i = 2; i < MAX; i++) {
            nFactorial %= INF;
            nFactorial *= (i % INF);
            nFactorial %= INF;
            dp[i] = nFactorial;
        }
        for(int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            
            // C(n+k-1, n)
            long denominator = modInverse(dp[n] * dp[k-1], INF);
            long ans = ((dp[n+k-1] % INF) * denominator) % INF;  
            System.out.println("Case " + caseNum + ": " + ans);          
        }
	}
    
    private static long modularExponentiation(long a, long b, long m) {
        long res = 1;
        a = a % m;
        while(b > 0) {
            if(b % 2 == 1) {
                res = (res * a) % m;
            } 
            b = b/2;
            a = (a * a) % m;
        }
        return res;
    }
    
    private static long modInverse(long b, long m) {
        // b %= m;
        long res = modularExponentiation(b, m-2, m);
        // System.out.println(res * b);
        if((res * (b % m)) % m == 1) {
            return res;
        }
        return -1;
    }
    
}

