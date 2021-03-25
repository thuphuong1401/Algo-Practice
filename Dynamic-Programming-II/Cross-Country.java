
/*
https://vn.spoj.com/problems/CRSCNTRY/
*/
import java.util.*;
import java.io.*;

class MyCode {
    static List<List<Integer>> input;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        while (numTestCases-- > 0) {
            input = new ArrayList<>();
            while (true) { // Đọc khi nào còn dòng
                int n = scan.nextInt();
                if (n == 0) {
                    break;
                }

                List<Integer> temp = new ArrayList<>();
                temp.add(n);
                while (true) { // Đọc khi nào còn số trên dòng
                    int x = scan.nextInt();
                    if (x == 0) {
                        break;
                    }
                    temp.add(x);
                }
                input.add(temp);
            }

            int max = solve();
            System.out.println(max);
        }
    }

    private static int solve() {
        List<Integer> agnes = input.get(0);
        int max = 0;
        for (int i = 1; i < input.size(); i++) {
            max = Math.max(max, LCS(agnes, input.get(i)));
        }
        return max;
    }

    private static int LCS(List<Integer> l1, List<Integer> l2) {
        int m = l1.size();
        int n = l2.size();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int c1 = l1.get(i - 1);
                int c2 = l2.get(j - 1);

                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];

    }
}
