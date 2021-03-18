/*
https://acm.timus.ru/problem.aspx?num=1009

Big idea: 
dp[i-1]: number of valid k-based numbers length i-1
- dp[i-1] * (k-1): number of valid k-based numbers length i formed by appending 0 -> k-1 to the beginning of a valid k-based number of length i-1
- dp[i-2] * (k-1): number of valid k-based numbers length i formed by make i-2 number 0 and append 0 -> k-1 to (i-1)th position.
*/
import java.util.*;
import java.io.*;

class MyCode {
    static int MAX = 20;
    static long dp[];
    
	public static void main (String[] args) {
        dp = new long[MAX];
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        dp[0] = 1;
        dp[1] = k-1;
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] * (k-1)) + (dp[i-2] * (k-1));
        }   
        System.out.println(dp[n]);
	}
}




