
/*
https://www.spoj.com/problems/SCUBADIV/
*/
import java.util.*;
import java.io.*;

class MyCode {
    static int oxigenRequired;
    static int nitrogenRequired;
    static int n;
    static int[] oxigen;
    static int[] nitrogen;
    static int[] weight;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            oxigenRequired = scan.nextInt();
            nitrogenRequired = scan.nextInt();
            n = scan.nextInt();
            oxigen = new int[n];
            nitrogen = new int[n];
            weight = new int[n];
            for (int i = 0; i < n; i++) {
                oxigen[i] = scan.nextInt();
                nitrogen[i] = scan.nextInt();
                weight[i] = scan.nextInt();
            }
            solve();
        }
    }

    private static void solve() {
        int[][][] dp = new int[1000][22][80];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= oxigenRequired; j++) {
                for (int k = 0; k <= nitrogenRequired; k++) {
                    dp[i][j][k] = 10000000;
                    if (j == 0 && k == 0) {
                        dp[i][j][k] = 0;
                    }
                }
            }
        }

        for (int j = 0; j <= oxigenRequired; j++) {
            for (int k = 0; k <= nitrogenRequired; k++) {
                if (j <= oxigen[0] && k <= nitrogen[0] && (j > 0 || k > 0)) {
                    dp[0][j][k] = weight[0];
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= oxigenRequired; j++) {
                for (int k = 0; k <= nitrogenRequired; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j <= oxigen[i] && k <= nitrogen[i]) {
                        dp[i][j][k] = Math.min(dp[i][j][k], weight[i]);
                    } else {
                        dp[i][j][k] = Math.min(dp[i][j][k],
                                weight[i] + dp[i - 1][Math.max(0, j - oxigen[i])][Math.max(0, k - nitrogen[i])]);
                    }
                }
            }
        }

        /*
         * for(int j = 0; j <= oxigenRequired; j++) { for(int k = 0; k <=
         * nitrogenRequired; k++) { System.out.print(dp[n-1][j][k] + " "); }
         * System.out.println(); }
         */
        System.out.println(dp[n - 1][oxigenRequired][nitrogenRequired]);
    }

}
