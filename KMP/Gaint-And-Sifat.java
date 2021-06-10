/*
https://www.codechef.com/problems/AUSAG
*/

import java.util.*;
import java.io.*;

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

    static String t, p;
    static int count;

    public static void main(String[] args) throws IOException {

        FastReader scan = new FastReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = scan.nextInt();
        for (int c = 1; c <= T; c++) {
            String inp = scan.nextLine();
            String[] temp = inp.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String str : temp) {
                if (!str.equals(" ")) {
                    sb.append(str);
                }
            }
            t = sb.toString();
            p = scan.next();

            count = 0;

            int[] prefix = new int[p.length()];
            KMPpreprocess(p, prefix);
            KMPsearch(t, p, prefix);

            out.write("Case " + c + ": " + count + "\n");
        }

        out.close();
    }

    private static void KMPpreprocess(String p, int[] prefix) {
        int m = p.length();
        int len = 0;
        int i = 1;
        while (i < m) {
            if (p.charAt(i) == p.charAt(len)) {
                len++;
                prefix[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = prefix[len - 1];
                } else {
                    prefix[i] = 0;
                    i++;
                }
            }
        }
    }

    private static void KMPsearch(String t, String p, int[] prefix) {
        int n = t.length();
        int m = p.length();
        int i = 0, j = 0;
        while (i < n) {
            if (p.charAt(j) == t.charAt(i)) {
                j++;
                i++;
            }

            if (j == m) {
                count++;
                j = prefix[j - 1];
            } else if (i < n && p.charAt(j) != t.charAt(i)) {
                if (j != 0) {
                    j = prefix[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

}
