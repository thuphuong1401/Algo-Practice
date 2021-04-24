/*
https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=931
*/
import java.util.*;
import java.io.*;

class MyCode {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (true) {
            if (!scan.hasNext()) {
                break;
            }
            int t = scan.nextInt();
            int w = scan.nextInt();
            int n = scan.nextInt();
            int[] d = new int[n];
            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                d[i] = scan.nextInt() * 3 * w;
                v[i] = scan.nextInt();
            }

            int[][] dp = new int[n + 1][t + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= t; j++) {
                    if (d[i - 1] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        int temp1 = dp[i - 1][j];
                        int temp2 = v[i - 1] + dp[i - 1][j - d[i - 1]];
                        dp[i][j] = Math.max(temp1, temp2);
                    }
                }
            }
            System.out.println(dp[n][t]);
            int count = 0;
            List<Integer> ans = new ArrayList<>();
            for (int i = n; i > 0; i--) {
                if (dp[i][t] != dp[i - 1][t]) {
                    count++;
                    ans.add(i - 1);
                    t -= d[i - 1];
                }
            }
            System.out.println(count);
            Collections.reverse(ans);
            for (int index : ans) {
                System.out.println(d[index] / (3 * w) + " " + v[index]);
            }

            System.out.println();
        }
    }
}
