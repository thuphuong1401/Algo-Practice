import java.util.*;
/*
https://onlinejudge.org/external/101/10179.pdf
*/
import java.io.*;

class MyCode {
    static final long MAX = 1000000000;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            long n = scan.nextLong();
            if (n == 0) {
                return;
            }
            long ans = phi(n);
            System.out.println(ans);
        }
    }

    private static long phi(long n) {
        long result = n;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                result = result / i * (i - 1);
            }
        }
        if (n > 1) {
            result = result / n * (n - 1);
        }
        return result;
    }

}
