import java.util.*;
import java.io.*;

/*
https://www.spoj.com/problems/ACODE/
*/

class MyCode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String line = scan.nextLine();
            if (line.equals("0")) {
                return;
            }
            long ans = numOfDecodings(line);
            System.out.println(ans);
        }
    }

    private static long numOfDecodings(String line) {
        int n = line.length();
        long[] dp = new long[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int curr = line.charAt(i) - '0';
            if (curr != 0) {
                dp[i] = dp[i - 1];
            }

            int prev = line.charAt(i - 1) - '0';
            int x = prev * 10 + curr;

            if (line.charAt(i - 1) - '0' != 0 && x <= 26) {
                dp[i] += dp[Math.max(0, i - 2)]; // good trick
            }
        }
        return dp[n - 1];
    }
}
