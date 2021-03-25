/*
https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=472
*/
import java.util.*;
import java.io.*;

class MyCode {
    static List<List<String>> input;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            input = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                List<String> temp = new ArrayList<>();
                while (true) {
                    String word = "";
                    if (scan.hasNext()) {
                        word = scan.next();
                    }
                    if (word.equals("#")) {
                        break;
                    }
                    temp.add(word);
                }
                input.add(temp);
            }
            List<String> ans = LCS();
            for (int i = ans.size() - 1; i >= 0; i--) {
                if (i == 0) {
                    System.out.print(ans.get(i));
                } else {
                    System.out.print(ans.get(i) + " ");
                }
            }
            System.out.println();
        }
    }

    private static List<String> LCS() {
        List<String> arr1 = input.get(0);
        List<String> arr2 = input.get(1);
        int m = arr1.size();
        int n = arr2.size();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                String curr1 = arr1.get(i - 1);
                String curr2 = arr2.get(j - 1);

                if (curr1.equals(curr2)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        List<String> ans = new ArrayList<>();
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            String curr1 = arr1.get(i - 1);
            String curr2 = arr2.get(j - 1);
            if (curr1.equals(curr2)) {
                ans.add(curr1);
                i--;
                j--;
            } else {
                if (dp[i - 1][j] >= dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return ans;
    }
}
