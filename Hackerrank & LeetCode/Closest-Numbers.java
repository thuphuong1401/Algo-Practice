/*
https://www.hackerrank.com/challenges/closest-numbers/problem
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the closestNumbers function below.
    static int[] closestNumbers(int[] arr) {
        Arrays.sort(arr);
        List<Integer> answer = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++) {
            int currDiff = arr[i+1] - arr[i];
            if(currDiff < minDiff) {
                minDiff = currDiff;
            }
        }
        for(int i = 0; i < arr.length-1; i++) {
            int currDiff = arr[i+1] - arr[i];
            if(currDiff == minDiff) {
                answer.add(arr[i]);
                answer.add(arr[i+1]);
            }
        }
        int[] toReturn = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            toReturn[i] = answer.get(i);
        }
        return toReturn;
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

        int[] result = closestNumbers(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
