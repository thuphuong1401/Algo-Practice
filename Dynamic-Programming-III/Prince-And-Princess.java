/*
https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1576
*/
import java.util.*;
import java.io.*;

class MyCode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        for (int test = 1; test <= numTestCases; test++) {
            int n = scan.nextInt();
            int p = scan.nextInt();
            int q = scan.nextInt();

            List<Integer> arr = new ArrayList<>();
            int[] pos = new int[n * n + 1];
            Arrays.fill(pos, -1);

            for (int i = 1; i <= p + 1; i++) {
                int x = scan.nextInt();
                pos[x] = i;
            }

            for (int i = 1; i <= q + 1; i++) {
                int y = scan.nextInt();
                if (pos[y] != -1) {
                    arr.add(pos[y]);
                }
            }
            int ans = LIS(arr);
            System.out.println("Case " + test + ": " + ans);
        }
    }

    private static int LIS(List<Integer> arr) {
        int length = 1;
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) <= arr.get(result.get(0))) {
                result.set(0, i);
            } else if (arr.get(i) > arr.get(result.get(length - 1))) {
                result.add(i);
                length++;
            } else {
                int pos = lowerBound(arr, result, length, arr.get(i));
                result.set(pos, i);
            }
        }
        return length;
    }

    private static int lowerBound(List<Integer> arr, List<Integer> sub, int n, int x) {
        int low = 0;
        int high = n;
        int pos = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int index = sub.get(mid);
            if (arr.get(index) >= x) {
                pos = mid;
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return pos;
    }

}
