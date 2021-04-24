/*
https://www.programmersought.com/article/40512508210/
*/
import java.util.*;
import java.io.*;

/*
dp[i][j][cnt]: max value of gold for [0...i] first bars, j length and cnt bars (0 <= cnt <= 2) sticking out
*/
class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scan.nextInt();
            int l = scan.nextInt() * 2;
            int[] a = new int[n+1];
            long[] v = new long[n+1];
            for(int i = 1; i <= n; i++) {
                a[i] = scan.nextInt();
                v[i] = scan.nextInt();
            }
            
            long[][][] dp = new long[n+1][l+1][3];
            
            /*
            3 choices:
            */
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= l; j++) {
                    for(int k = 0; k <= 2; k++) {
                        dp[i][j][k] = dp[i-1][j][k]; // not including the ith bar
                        if(j >= a[i] * 2) { // include the ith bar INSIDE the container
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-(a[i] * 2)][k] + v[i]);
                        } 
                        if(j >= a[i] && k > 0) { // stick the ith bar OUTSIDE the container 
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-a[i]][k-1] + v[i]);
                        }
                    }
                }
            }
            
            long ans = -1;
            
            for(long value : v) {
                ans = Math.max(ans, value);
            }
            for(int i = 0; i <= 2; i++) {
                ans = Math.max(ans, dp[n][l][i]);   
            }
            System.out.println("Case #" + caseNum + ": " + ans);
            
        }    
	}
}
