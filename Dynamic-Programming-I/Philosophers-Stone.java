/*
https://www.spoj.com/problems/BYTESM2/
*/
import java.util.*;
import java.io.*;

class MyCode {

    static int[][] stone;
    static int h, w;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        while (numTestCases-- > 0) {
            h = scan.nextInt();
            w = scan.nextInt();
            stone = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    stone[i][j] = scan.nextInt();
                }
            }
            long ans = maxStones();
            System.out.println(ans);
        }
    }

    private static long maxStones() {
        int[][] dp = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                dp[i][j] = stone[i][j];
            }
        }

        for (int i = 1; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int left = Math.max(0, j - 1);
                int right = Math.min(w - 1, j + 1);
                dp[i][j] += Math.max(Math.max(dp[i - 1][left], dp[i - 1][j]), dp[i - 1][right]);
            }
        }

        long max = -1;
        for (int i = 0; i < w; i++) {
            max = Math.max(max, dp[h - 1][i]);
        }

        return max;
    }

}
