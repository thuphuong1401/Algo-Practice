/*
https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=167
*/
import java.util.*;
import java.io.*;

class MyCode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = 1;
        while (true) { // test case
            int n = scan.nextInt();
            if (n == -1) {
                return; // het tests
            }
            List<Integer> arr = new ArrayList<>();
            arr.add(n);
            while (true) {
                int x = scan.nextInt();
                if (x == -1) {
                    break;
                }
                arr.add(x);
            }
            int[] input = new int[arr.size()];
            for (int i = 0; i < arr.size(); i++) {
                input[i] = arr.get(i);
            }
            int length = longestDecreasingSub(input);
            System.out.println("Test #" + testCase + ":");
            System.out.println("  maximum possible interceptions: " + length);
            System.out.println();
            testCase++;
        }
    }

    private static int longestDecreasingSub(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] <= arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}






import java.util.*;
import java.io.*;

class MyCode {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int testCase = 1;
        while (true) { // test case
            int n = scan.nextInt();
            if (n == -1) {
                return; // het tests
            }
            List<Integer> arr = new ArrayList<>();
            arr.add(n);
            while (true) {
                int x = scan.nextInt();
                if (x == -1) {
                    break;
                }
                arr.add(x);
            }

            int length = longestDecreasingSub(arr);
            System.out.println("Test #" + testCase + ":");
            System.out.println("  maximum possible interceptions: " + length);
            System.out.println();
            testCase++;
        }
    }

    private static int longestDecreasingSub(List<Integer> arr) {
        int n = arr.size();
        int length = 1;
        List<Integer> result = new ArrayList<>();
        result.add(0);

        // result: decreasing
        // result[0]: vtri cua ptu lon nhat, a[i] >= a[result[0]]
        // result[n - 1]: vtri cua ptu nho nhat, a[i] <= a[result[n-1]] => append va
        // cuoi

        for (int i = 1; i < n; i++) {
            if (arr.get(i) > arr.get(result.get(0))) {
                result.set(0, i);
            } else if (arr.get(i) <= arr.get(result.get(length - 1))) {
                result.add(i);
                length++;
            } else {
                // search largest element >= arr.get(i)
                int pos = firstPosLessThanOrEqualToX(arr, result, length, arr.get(i));
                if (arr.get(i).intValue() == arr.get(result.get(pos)).intValue()) {
                    result.add(pos, i);
                    result.remove(result.size() - 1);
                    // length++;
                } else if (arr.get(i).intValue() > arr.get(result.get(pos)).intValue()) {
                    result.set(pos, i);
                }
            }

            /*
             * for (int x : result) { System.out.print(x + " "); } System.out.println();
             */
        }
        return length;
    }

    /*
     * longest increasing: vtri dau tien >= x => thay x vao vi tri nay longest
     * decreasing: vtri dau tien <= x => thay x vao vi tri nay
     */

    private static int firstPosLessThanOrEqualToX(List<Integer> a, List<Integer> sub, int n, int x) {
        int left = 0, right = n;
        int pos = n;

        // 8 7 7 7 4 3 2 (x = 7, vi tri dau tien <= 7)
        while (left < right) {
            int mid = left + (right - left) / 2;
            int index = sub.get(mid);
            if (a.get(index) < x) {
                pos = mid;
                right = mid;
                // left = mid+1;
            } else {
                left = mid + 1;
                // right = mid-1;
            }
        }

        return pos;
    }

}





/*
Concise O(nlogn) solution
*/
import java.util.*;
import java.io.*;

class MyCode {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int testCase = 1;
        while (true) { // test case
            int n = scan.nextInt();
            if (n == -1) {
                return; // het tests
            }
            List<Integer> arr = new ArrayList<>();
            arr.add(n);
            while (true) {
                int x = scan.nextInt();
                if (x == -1) {
                    break;
                }
                arr.add(x);
            }

            int length = longestDecreasingSub(arr);
            System.out.println("Test #" + testCase + ":");
            System.out.println("  maximum possible interceptions: " + length);
            System.out.println();
            testCase++;
        }
    }

    private static int longestDecreasingSub(List<Integer> arr) {
        int n = arr.size();
        int length = 1;
        List<Integer> result = new ArrayList<>();
        result.add(0);

        // result: decreasing
        // result[0]: vtri cua ptu lon nhat, a[i] >= a[result[0]]
        // result[n - 1]: vtri cua ptu nho nhat, a[i] <= a[result[n-1]] => append va
        // cuoi

        for (int i = 1; i < n; i++) {
            if (arr.get(i) > arr.get(result.get(0))) {
                result.set(0, i);
            } else if (arr.get(i) <= arr.get(result.get(length - 1))) {
                result.add(i);
                length++;
            } else {
                // search largest element >= arr.get(i)
                int pos = firstPosLessThanX(arr, result, length, arr.get(i));
                result.set(pos, i);
            }

            /*
             * for (int x : result) { System.out.print(x + " "); } System.out.println();
             */
        }
        return length;
    }

    /*
     * longest increasing: vtri dau tien >= x => thay x vao vi tri nay longest
     * decreasing: vtri dau tien <= x => thay x vao vi tri nay
     */

    private static int firstPosLessThanX(List<Integer> a, List<Integer> sub, int n, int x) {
        int left = 0, right = n;
        int pos = n;

        // 8 7 7 7 4 3 2 (x = 7, vi tri dau tien <= 7)
        while (left < right) {
            int mid = left + (right - left) / 2;
            int index = sub.get(mid);
            if (a.get(index) < x) {
                pos = mid;
                right = mid;
                // left = mid+1;
            } else {
                left = mid + 1;
                // right = mid-1;
            }
        }

        return pos;
    }

}






import java.util.*;
import java.io.*;

class MyCode {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int testCase = 1;
        while (true) { // test case
            int n = scan.nextInt();
            if (n == -1) {
                return; // het tests
            }
            List<Integer> arr = new ArrayList<>();
            arr.add(n);
            while (true) {
                int x = scan.nextInt();
                if (x == -1) {
                    break;
                }
                arr.add(x);
            }

            int length = longestDecreasingSub(arr);
            System.out.println("Test #" + testCase + ":");
            System.out.println("  maximum possible interceptions: " + length);
            System.out.println();
            testCase++;
        }
    }

    private static int longestDecreasingSub(List<Integer> arr) {
        Collections.reverse(arr);
        int length = 1;
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(result.get(0))) {
                result.set(0, i);
            } else if (arr.get(i) >= arr.get(result.get(length - 1))) {
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
        int left = 0, right = n;
        int pos = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int index = sub.get(mid);
            if (arr.get(index) > x) {
                pos = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return pos;
    }

}
