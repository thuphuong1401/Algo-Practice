/*
https://practice.geeksforgeeks.org/problems/palindromic-series5346/1
*/
import java.util.*;
import java.io.*;

class MyCode {

    static int n;
    static int numDigit;
    static int sumDigit;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            n = scan.nextInt();
            process(n);
            String s = buildString();
            // System.out.println(s);
            boolean ans = isPalindrome(s);
            if (isPalindrome(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static String buildString() {
        String str = Integer.toString(n);
        int q = sumDigit / str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            sb.append(str);
        }
        int r = sumDigit % str.length();
        for (int i = 0; i < r; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    private static void process(int n) {
        numDigit = 0;
        sumDigit = 0;
        while (n != 0) {
            int digit = n % 10;
            n /= 10;
            numDigit++;
            sumDigit += digit;
        }
    }

    private static boolean isPalindrome(String s) {
        int l = s.length();
        for (int i = 0; i < l / 2; i++) {
            if (s.charAt(i) != s.charAt(l - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
