
/*
https://codeforces.com/problemset/problem/459/D
First ever problem I solved using Fenwick Tree!
*/
import java.util.*;
import java.io.*;

class Main {

    static int n;
    static int[] fenwick;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextLong();
        }

        fenwick = new int[n + 1];

        int[] l = new int[n];
        int[] r = new int[n];
        int[] cnt = new int[n + 1]; // cnt[i] counts frequency of r[j] = i

        // count the frequency of r[j] values
        Map<Long, Integer> freqOfR = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            if (freqOfR.containsKey(arr[i])) {
                freqOfR.put(arr[i], freqOfR.get(arr[i]) + 1);
            } else {
                freqOfR.put(arr[i], 1);
            }
            r[i] = freqOfR.get(arr[i]);
            update(r[i], 1); // use Fenwick tree to count frequency of r[i] values (cumulative frequency)
        }

        Map<Long, Integer> freqOfL = new HashMap<>();
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (freqOfL.containsKey(arr[i])) {
                freqOfL.put(arr[i], freqOfL.get(arr[i]) + 1);
            } else {
                freqOfL.put(arr[i], 1);
            }
            l[i] = freqOfL.get(arr[i]);
            update(r[i], -1);
            res += get(l[i] - 1);
        }

        System.out.println(res);

    }

    private static void update(int index, int val) {
        while (index <= n) {
            fenwick[index] += val;
            index += (index & (-index));
        }
    }

    private static int get(int p) {
        int ans = 0;
        while (p > 0) {
            ans += fenwick[p];
            p -= (p & (-p));
        }
        return ans;
    }

}
