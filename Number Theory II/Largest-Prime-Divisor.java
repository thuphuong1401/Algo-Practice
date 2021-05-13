/*
https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=2461
*/
import java.util.*;
import java.io.*;

class MyCode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            long n = scan.nextLong();
            if (n == 0) {
                return;
            }
            System.out.println(largestPrimeDivisor(Math.abs(n)));
        }
    }

    private static long largestPrimeDivisor(long n) {
        long numDivisors = 0;
        long largest = -1;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                numDivisors++;
                largest = i;
            }
            while (n % i == 0) {
                n /= i;
            }
        }

        if (numDivisors > 0 && n > 1) {
            return n;
        }

        if (numDivisors == 1) {
            return -1;
        }

        return largest;
    }

}
