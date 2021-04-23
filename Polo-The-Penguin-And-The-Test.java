/*
https://www.codechef.com/problems/PPTEST
*/
import java.util.*;
import java.io.*;

class MyCode {
    static int N;
    static int W;
    static int[] values;
    static int[] time;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            N = scan.nextInt();
            W = scan.nextInt();
            values = new int[N];
            time = new int[N];
            for (int i = 0; i < N; i++) {
                int c_i = scan.nextInt();
                int p_i = scan.nextInt();
                int t_i = scan.nextInt();

                values[i] = c_i * p_i;
                time[i] = t_i;
            }

            knapsack();
        }
    }

    // /(2, 3), (6, 5), (9, 3)

    private static void knapsack() {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                int weight = time[i - 1];
                if (weight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int temp1 = dp[i - 1][j];
                    int temp2 = dp[i - 1][j - time[i - 1]] + values[i - 1];
                    dp[i][j] = Math.max(temp1, temp2);
                }
            }
        }

        System.out.println(dp[N][W]);
    }

}
