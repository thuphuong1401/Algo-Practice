/*
https://codeforces.com/group/swEqtABRxe/contest/324151/problem/B
*/

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        while (numTestCases-- > 0) {
            int n = scan.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextLong();
            }
            long ans = 0;
            int i = 0;
            while (i < n) {
                int j = i + 1;
                while (j < n - 1 && arr[j] <= arr[i]) {
                    j++;
                }
                if (i < n && j < n) {
                    ans += (arr[i] + arr[j] + (j - i + 1));
                }
                i = j;
            }
            System.out.println(ans);
        }
    }
}
