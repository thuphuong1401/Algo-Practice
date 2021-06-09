/*
https://www.spoj.com/problems/RPLB/
*/
import java.io.*;
import java.util.*;

class MyCode {

  static class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader(InputStream in) {
      br = new BufferedReader(new InputStreamReader(in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }

  public static void main(String[] args) throws IOException {
    FastReader scan = new FastReader(System.in);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    int numTests = scan.nextInt();
    for (int t = 1; t <= numTests; t++) {
      int n = scan.nextInt();
      int k = scan.nextInt();
      int[] bush = new int[n];

      for (int i = 0; i < n; i++) {
        bush[i] = scan.nextInt();
      }

      // similar to the knapsack problem
      int[][] dp = new int[n + 1][k + 1];

      for (int j = bush[0]; j <= k; j++) {
        dp[1][j] = bush[0];
      }

      for (int i = 2; i <= n; i++) {
        for (int j = 1; j <= k; j++) {
          if (bush[i - 1] > j) {
            dp[i][j] = dp[i - 1][j];
          } else {
            int chooseI = dp[i - 2][j - bush[i - 1]] + bush[i - 1];
            int notChooseI = dp[i - 1][j];
            dp[i][j] = Math.max(chooseI, notChooseI);
          }
        }
      }

      out.write("Scenario #" + t + ": " + dp[n][k] + "\n");
    }

    out.close();
  }
}
