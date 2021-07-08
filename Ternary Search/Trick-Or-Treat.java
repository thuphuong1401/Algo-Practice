/*
https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=0&problem=3349&mosmsg=Submission+received+with+ID+26553014
*/
import java.util.*;
import java.io.*;

class FastReader {
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

public class test {
    static int n;
    static double[][] arr;
    static final double MIN = -200000;
    static final double MAX = 200000;

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader(System.in);
        // BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            n = sc.nextInt();
            if(n == 0) {
                break;
            }
            arr = new double[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextDouble();
                arr[i][1] = sc.nextDouble();
            }
            //sc.nextLine();

            solve();
        }
    }

    private static void solve() {
        double[] minIndex = ternarySearch();
        System.out.println(minIndex[0] + " " + minIndex[1]);
    }

    private static double[] ternarySearch() {
        double l = MIN;
        double r = MAX;
        double[] ans = new double[2];
        for (int round = 0; round <= 100; round++) {
            double m1 = l + (r - l) / 3;
            double m2 = r - (r - l) / 3;
            double f_m1 = f(new double[] { m1, 0.0 });
            double f_m2 = f(new double[] { m2, 0.0 });

            if (f_m1 <= f_m2) {
                r = m2;
            }

            if (f_m1 >= f_m2) {
                l = m1;
            }
        }
        ans[0] = l; // ans[0] = r also works
        ans[1] = f(new double[]{l, 0.0});
        return ans;
    }

    // f((x, 0)) = max(dist(x_i, y_i), (x, 0))
    // f is is U-shaped
    private static double f(double[] source) {
        double ans = 0.0;
        for (int i = 0; i < n; i++) {
            double d = dist(source, arr[i]);
            ans = Math.max(ans, d);
        }
        return ans;
    }

    private static double dist(double[] pt1, double[] pt2) {
        return Math.sqrt(Math.pow(pt2[0] - pt1[0], 2) + Math.pow(pt2[1] - pt1[1], 2));
    }

}

/*
 * n houses
 * 
 * f((x, 0)) = max(dist(x_i, y_i), (x, 0)) => convex bc max of convex functions
 * are convex => use ternary search de search min of f
 */


 /*
2
1.5 1.5
3 0

1
0 0

4
1 4
4 4
-3 3
2 4

5
4 7
-4 0
7 -6
-2 4
8 -5

0
*/
