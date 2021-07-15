/*
https://www.codechef.com/problems/AMCS03

Key observation: f(T) is bitonic, i.e. decreasing -> increasing. 
View the following image to understand why: https://drive.google.com/file/d/15XpGGtdXp9PPhJvvMyiUUmqTI5L8yiia/view?usp=sharing
In that image, every line represents the position of a racer (because the position is given as a linear function)
max-min is first big, then small, then big.
=> f(T) is U-shaped.
*/ 
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

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


public class Main {
    static int N, K;
    static int[] S_i;
    static int[] D_i;
    static final int eps = (int)1e-9;
    
    public static void main(String[] args) {
        FastReader fr = new FastReader(System.in);
        N = fr.nextInt();
        K = fr.nextInt();
        S_i = new int[N];
        D_i = new int[N];
        for(int i = 0; i < N; i++) {
            S_i[i] = fr.nextInt();
            D_i[i] = fr.nextInt();
        }
        
        double res = ternarySearch();
        System.out.printf("%.6f", res);
        
    }
    
    private static double f(double T) {
        double max, min, temp;
        
        max = S_i[0] * T + D_i[0] * 1.0;
        min = S_i[0] * T + D_i[0] * 1.0;
        
        for(int i = 1; i < N; i++) {
            temp = S_i[i] * T + D_i[i] * 1.0;
            
            if(temp - max > eps) {
                max = temp;
            } else if(min - temp > eps) {
                min = temp; 
            }
        }
        return max - min;
    }
    
    private static double ternarySearch() {
        double l = 0.0;
        double r = K * 1.0;
        for(int i = 0; i < 100; i++) {
            double m1 = l + (r - l) / 3.0;
            double m2 = r - (r - l) / 3.0;
            
            double f_m1 = f(m1);
            double f_m2 = f(m2);
            
            if(f_m1 >= f_m2) {
                l = m1;
            }
            
            if(f_m1 <= f_m2) {
                r = m2;
            }
        }   
        return Math.min(f(l), f(r));
    }
    
    
}


