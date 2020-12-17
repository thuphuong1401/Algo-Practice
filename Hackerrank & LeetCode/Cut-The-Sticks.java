/*
https://www.hackerrank.com/challenges/cut-the-sticks/problem
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cutTheSticks function below.
    static List<Integer> cutTheSticks(int[] arr) {
        List<Integer> result = new ArrayList<>();

        // before every iteration:
        /*
         * - Get array size, add to result - Find min length in arr - Find & discard all
         * pieces with such min length - Subtract min length from all other pieces Stop
         * the reiteration until you have + All the remaining are of min length + There
         * is only 1 stick left +
         */

        while (true) {
            if (arr.length == 1) {
                result.add(1);
                break;
            }
            if (!isValid(arr)) {
                break;
            }

            int currSize = 0;
            int minLength = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    minLength = Math.min(minLength, arr[i]);
                    currSize++;
                }
            }
            result.add(currSize);
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    arr[i] -= minLength;
                }
            }
        }
        return result;
    }

    static boolean isValid(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return true;
            }
        }
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        List<Integer> result = cutTheSticks(arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
