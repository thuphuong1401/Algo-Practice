
/*
https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=2512

This is a very nice variation of the coin change problem: still coin change, but it does not allow using a bill more than once
The loop goes backward instead of forward.
In the original coin change problem where coins come in UNLIMITED supplies, the loop goes forward since a bill can be used many times.
In this variation, a loop goes backward since when it looks at dp[v] to construct dp[v + C], dp[v] has been constructed without using the current coin C
*/
import java.util.*;
import java.io.*;

class MyCode {
    static final int MAX = 20000;
    static final int INF = 1000000;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int price = scan.nextInt();
            int n = scan.nextInt();
            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = scan.nextInt();
            }
            int[] dp = new int[MAX];
            Arrays.fill(dp, INF);
            dp[0] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = MAX - coins[i] - 1; j >= 0; j--) { // loop goes backward
                    if (dp[j] != INF) {
                        dp[j + coins[i]] = Math.min(dp[j + coins[i]], dp[j] + 1);
                    }
                }
            }
            int minPay = -1;
            int minBills = 0;
            for (int i = price; i < MAX; i++) {
                if (dp[i] != INF) {
                    minPay = i;
                    minBills = dp[i];
                    break;
                }
            }
            System.out.println(minPay + " " + minBills);
        }

    }
}
