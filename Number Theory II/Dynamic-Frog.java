/*
https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=659&page=show_problem&problem=2098
*/ 
import java.util.*;
import java.io.*;

class MyCode {
    static final int MAX = 105;
    static boolean isLarge[];
    static int x[], t, N, D;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        t = scan.nextInt();
        for (int test = 1; test <= t; test++) {
            N = scan.nextInt();
            D = scan.nextInt();
            isLarge = new boolean[N + 2];
            x = new int[N + 2];
            for (int i = 1; i <= N; i++) {
                String s = scan.next();
                isLarge[i] = (s.charAt(0) == 'B');
                x[i] = Integer.parseInt(s.substring(2));
            }
            isLarge[0] = true;
            x[0] = 0;
            isLarge[N + 1] = true;
            x[N + 1] = D;

            int ans = 0;
            int lastLarge = 0;
            for (int i = 1; i <= N + 1; i++) {
                if (isLarge[i]) {
                    ans = Math.max(ans, getMinimaxLeap(lastLarge, i));
                    lastLarge = i;
                }
            }
            System.out.println("Case " + test + ": " + ans);
        }
    }

    private static int getMinimaxLeap(int l, int r) {
        if (l + 1 == r) {
            return x[r] - x[l];
        }
        int leap = 0;
        for (int i = l; i < r - 1; i++) {
            leap = Math.max(leap, x[i + 2] - x[i]);
        }
        return leap;
    }

}
