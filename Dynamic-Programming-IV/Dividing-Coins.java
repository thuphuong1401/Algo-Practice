/*
https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=7&page=show_problem&problem=503
*/
import java.util.*;
import java.io.*;

class MyCode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int[] coins = new int[n];
            int W = 0;
            for (int i = 0; i < n; i++) {
                coins[i] = scan.nextInt();
                W += coins[i];
            }
            boolean[][] dp = new boolean[n + 1][(W + 1) / 2 + 1];
            dp[0][0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= W / 2; j++) {
                    if (j == 0) {
                        dp[i][j] = true;
                        continue;
                    }
                    if (coins[i - 1] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - coins[i - 1]];
                    }
                }
            }

            int minDiff = Integer.MAX_VALUE;
            for (int j = 0; j <= W / 2; j++) {
                if (dp[n][j] && Math.abs(W - j - j) < minDiff) {
                    minDiff = Math.abs(W - j - j);
                }
            }
            System.out.println(minDiff);
        }

        /*
         * dp[N][W]
         * 
         * minimize |W - j - j| voi j: 0 -> W/2 co cach nao chia sao cho tong tien bang
         * j? dp[j][N]: true/false
         * 
         * dp[j][N] phu thuoc the nao dp[j - 1][N - 1], dp[j][N - 1], dp[j - 1][N]
         * 
         * dp[coin][sum] = dp[coin-1][sum] || dp[coin][sum-coin]
         * 
         * for coin in coins: for sum in (0, W/2): if coin > sum: dp[coin][sum] =
         * dp[coin-1][sum] else: dp[coin -
         * 
         */
    }
}
