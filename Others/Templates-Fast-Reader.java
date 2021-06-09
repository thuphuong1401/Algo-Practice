/*
Tested on the following input:

3 4
0 1
0 2
0 0
1 2

It works.
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
                }
                catch (IOException e) {
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
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        
    }
    
    
	public static void main (String[] args) throws IOException {
        FastReader sc = new FastReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        //System.out.println(n + " " + m);
        out.write(n + " " + m + "\n");
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            out.write(u + " " + v + "\n");
        }
        
        out.close();
	}
}
