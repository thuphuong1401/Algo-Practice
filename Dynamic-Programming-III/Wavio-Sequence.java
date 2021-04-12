/*
https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=1475
*/

/*
O(n^2) TLE solution
*/

import java.util.*;
import java.io.*;

class MyCode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
            int[] lisDP = new int[n];
            lisDP = LIS(arr, lisDP);
            int[] ldsDP = new int[n];
            arr = reverse(arr);
            ldsDP = LIS(arr, ldsDP);

            int maxWaivo = 0;

            /*
             * for(int i : lisDP) { System.out.print(i + " "); } System.out.println();
             * 
             * 
             * for(int i : ldsDP) { System.out.print(i + " "); } System.out.println();
             */

            for (int i = 0; i < n; i++) {
                int temp = Math.min(lisDP[i], ldsDP[n - i - 1]);
                maxWaivo = Math.max(maxWaivo, temp * 2 - 1);
            }
            System.out.println(maxWaivo);
        }
    }

    private static int[] LIS(int[] arr, int[] dp) {
        int n = arr.length;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        return dp;
    }

    private static int[] reverse(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        return arr;
    }
}



/*
Non TLE solution
*/
import java.util.*;
import java.io.*;

class MyCode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }

            int[] lisDP = new int[n];
            lisDP = LIS(arr, lisDP);
            int[] ldsDP = new int[n];
            arr = reverse(arr);
            ldsDP = LIS(arr, ldsDP);

            int maxWaivo = 0;

            for (int i = 0; i < n; i++) {
                int temp = Math.min(lisDP[i], ldsDP[n - i - 1]);
                maxWaivo = Math.max(maxWaivo, temp * 2 - 1);
            }
            System.out.println(maxWaivo);
        }
    }

    private static int[] LIS(int[] arr, int[] dp) {
        int length = 1;
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        result.add(0);
        int pos = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[result.get(0)]) {
                result.set(0, i);
                pos = 0;
            } else if (arr[i] > arr[result.get(length - 1)]) {
                result.add(i);
                pos = length;
                length++;
            } else {
                pos = lowerBound(arr, result, length, arr[i]);
                result.set(pos, i);
            }
            dp[i] = pos + 1;
        }
        return dp;
    }

    private static int lowerBound(int[] arr, List<Integer> result, int n, int x) {
        int left = 0, right = n;
        int pos = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int index = result.get(mid);
            if (arr[index] >= x) {
                pos = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }

    private static int[] reverse(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        return arr;
    }
}



