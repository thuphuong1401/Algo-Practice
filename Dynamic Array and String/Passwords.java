/*
https://codeforces.com/problemset/problem/721/B
*/

import java.util.Scanner;

public class Passwords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] cnt = new int[101];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            cnt[s.length()]++;
        }

        String password = sc.next();
        int best_time = 0, worst_time = 0;

        for (int i = 0; i < password.length(); i++) {
            best_time += cnt[i];
        }

        worst_time = best_time + cnt[password.length()] - 1;

        best_time += (best_time / k) * 5;
        worst_time += (worst_time / k) * 5;

        System.out.print((best_time + 1) + " " + (worst_time + 1));
    }
}
