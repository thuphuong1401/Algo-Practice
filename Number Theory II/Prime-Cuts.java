/*
https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=347
*/
import java.util.*;
import java.io.*;

class MyCode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean[] mark = sieve(1000);
        while (scan.hasNext()) {
            int N = scan.nextInt();
            int C = scan.nextInt();
            List<Integer> primesBelow1000 = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (mark[i]) {
                    primesBelow1000.add(i);
                }
            }

            int size = primesBelow1000.size();
            System.out.println(N + " " + C + ": ");
            if (size >= (2 * C - 1)) {
                for (int i = size / 2 - C + size % 2; i < size / 2 + C; i++) {
                    System.out.print(primesBelow1000.get(i) + " ");
                }
            } else {
                for (int prime : primesBelow1000) {
                    System.out.print(prime + " ");
                }
            }
            System.out.println();
        }

    }

    private static boolean[] sieve(int n) {
        boolean[] mark = new boolean[n + 1];
        Arrays.fill(mark, true);
        mark[0] = mark[1] = false;
        mark[1] = true;
        for (int i = 2; i <= n; i++) {
            if (mark[i] == true) {
                for (int j = i * 2; j <= n; j += i) {
                    mark[j] = false;
                }
            }
        }
        return mark;
    }

}
