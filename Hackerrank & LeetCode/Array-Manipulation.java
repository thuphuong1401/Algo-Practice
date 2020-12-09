/*
https://www.hackerrank.com/challenges/crush/problem

After contemplating the popular approach for solving this, here is how I wrapped my head around it.

For every input line of a-b-k, you are given the range (a to b) where the values increase by k. So instead of keeping track of actual values increasing, just keep track of the rate of change (i.e. a slope) in terms of where the rate started its increase and where it stopped its increase. This is done by adding k to the "a" position of your array and adding -k to the "b+1" position of your array for every input line a-b-k, and that's it. "b+1" is used because the increase still applied at "b".

The maximum final value is equivalent to the maximum accumulated "slope" starting from the first position, because it is the spot which incremented more than all other places. Accumulated "slope" means to you add slope changes in position 0 to position 1, then add that to position 2, and so forth, looking for the point where it was the greatest.
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        int[] arr = new int[n+1];
        for(int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];
            arr[a-1] += k;
            arr[b] -= k;
        }
        
        long currPrefixSum = 0;
        long maxSum = 0;
        for(int i = 0; i < n; i++) {
            currPrefixSum += arr[i];
            maxSum = Math.max(maxSum, currPrefixSum);
        }
        return maxSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
