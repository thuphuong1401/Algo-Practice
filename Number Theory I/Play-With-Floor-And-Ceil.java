/*
https://onlinejudge.org/external/106/10673.pdf
*/
import java.util.*;
import java.io.*;

class MyCode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            long x = scan.nextLong();
            long k = scan.nextLong();

            long a = (long) Math.floor(1.0 * x / k);
            long b = (long) Math.ceil(1.0 * x / k);
            List<Long> result = extendedEuclid(a, b);
            long gcd = result.get(0);
            long l1 = result.get(1);
            long l2 = result.get(2);
            // long multiplicativeInverse = (l1 + b) % b;
            // System.out.println((l1 * multiplicativeInverse) % b);
            // long p = multiplicativeInverse * x;
            // System.out.println(a * l1 + b * l2 == gcd);
            // System.out.println(a + "*" + l1 + " + " + b + "*" + l2 + " = " + gcd);
            long p = l1 * (x / gcd);
            long q = l2 * (x / gcd);
            System.out.println(p + " " + q);
            // System.out.println(p * a + q * b == x);
        }
    }

    private static List<Long> extendedEuclid(long b, long m) {
        List<Long> result = new ArrayList<>();
        long x1 = 0, y1 = 1;
        long x2 = 1, y2 = 0;
        long q, r;
        long x = 1, y = 0;
        while (m != 0) {
            q = b / m;
            r = b % m;
            x = x2 - q * x1;
            y = y2 - q * y1;
            x2 = x1;
            y2 = y1;
            x1 = x;
            y1 = y;
            b = m;
            m = r;
        }
        result.add(b);
        result.add(x2);
        result.add(y2);
        return result;
    }

}
