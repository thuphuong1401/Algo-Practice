/*
https://codeforces.com/contest/439/problem/D
*/
// package whatever; // don't place package name!
// Installed Libraries: JSON-Simple, JUNit 4, Apache Commons Lang3
import java.io.*;
import java.util.*;

public class Main {

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

    static int n, m;
    static long[] a;
    static long[] b;
    static long max_a_b;
    static final long MAX = (long) 1e9;

    public static void main(String[] args) throws IOException {
        FastReader scan = new FastReader(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        a = new long[n];
        b = new long[m];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextLong();
        }
        for (int i = 0; i < m; i++) {
            b[i] = scan.nextLong();
        }
        solve();
    }

    /*
     * There exists x s.t. min(a) >= x and max(b) <= x f(x) = min number of
     * operations s.t. elements of a >= x and elements of b <= x f(x) = f_a(x) +
     * f_b(x) Use ternary search to find x f is u-shaped
     */
    private static void solve() {
        max_a_b = -1L;
        for(long num : a) {
            max_a_b = Math.max(max_a_b, num);
        }
        for(long num : b) {
            max_a_b = Math.max(max_a_b, num);
        }
        long minOps = ternarySearch();
        System.out.println(minOps);
    }

    private static long f(long x) {
        long totalOps = 0;
        for (long num : a) {
            if (num < x) {
                totalOps += (x - num);
            }
        }
        for (long num : b) {
            if (num > x) {
                totalOps += (num - x);
            }
        }
        return totalOps;
    }

    private static long ternarySearch() {
        long l = 1L;
        long r = max_a_b;
        while (r - l >= 3 * 1L) {
            long m1 = l + (r - l) / 3;
            long m2 = r - (r - l) / 3;

            long f_m1 = f(m1);
            long f_m2 = f(m2);

            if (f_m1 <= f_m2) {
                r = m2;
            }
            if (f_m1 >= f_m2) {
                l = m1;
            }
        }
        long min_x = Long.MAX_VALUE;
        for (long i = l; i <= r; i++) {
            min_x = Math.min(min_x, f(i));
        }
        return min_x;
    }

}
