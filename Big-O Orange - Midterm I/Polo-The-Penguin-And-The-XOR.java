
/*
https://discuss.codechef.com/t/ppxor-editorial/3505
*/
import java.util.*;
import java.io.*;

class MyCode {
    static int T;
    static int N;
    static long[] arr;
    static long[] S;
    static long[] numOnes;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        T = scan.nextInt();
        while (T-- > 0) {
            N = scan.nextInt();
            arr = new long[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scan.nextLong();
            }

            S = new long[N + 1];
            for (int i = 1; i <= N; i++) {
                S[i] = S[i - 1] ^ arr[i - 1];
            }

            numOnes = new long[32];

            long ans = 0;
            for (int r = 1; r <= N; r++) {
                long s = getSum(r);
                ans += s;
            }
            System.out.println(ans);
        }
    }

    /*
     * No carry needed x0*2^0 + x1*2^1 + x2*2^2 + ..
     * 
     * 3 * 2^1 + 0 * 2^2 (khong nho) ~ 1 * 2^1 + 1 * 2^2
     * 
     * 1 0 1 0 0 1 ----- 1 1 0 => 0 + 1*2 + 1*4 = 6
     * 
     * 1 0 1 0 0 1 ----- 1 0 2 => 2 + 1*4 = 6
     */

    /*
     * No need to loop from l to r [1, 2, 3] r = 3 [1, 2, 3, 4] r = 4
     */

    private static long getSum(int r) {

        for (int i = 31; i >= 0; i--) {
            long Ci = 0; // number of 1 bit in jth column
            long bit = (S[r - 1] >> i) & 1;
            numOnes[i] += bit;
        }

        long ans = 0;
        for (int i = 31; i >= 0; i--) {
            long bit = (S[r] >> i) & 1;
            if (bit == 1) {
                ans += (r - numOnes[i]) * Math.pow(2, i);
            } else {
                ans += numOnes[i] * Math.pow(2, i);
            }
        }
        return ans;
    }

}
