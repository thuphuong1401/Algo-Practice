/*
AtCoder beginner contest
https://atcoder.jp/contests/abc147/tasks/abc147_d
*/
import java.util.*;
import java.io.*;

class MyCode {
    static final long MOD = (long) 1e9 + 7;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextLong();
        }

        long[] cnt = new long[64];
        long ans = 0;
        for (int i = 0; i < 64; i++) {
            long cntZeros = 0;
            long cntOnes = 0;
            for (int j = 0; j < N; j++) {
                long currBit = ((arr[j] >> i) & 1);
                if (currBit == 1L) {
                    cntOnes++;
                } else {
                    cntZeros++;
                }
            }
            long p = cntOnes * cntZeros; // number of pairs whose XOR has ith bit = 1
            p %= MOD;
            long temp = (1L << i) % MOD;
            ans += (temp * p) % MOD;
            ans %= MOD;
        }
        System.out.println(ans);
    }
}
