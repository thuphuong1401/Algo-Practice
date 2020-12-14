/*
https://www.hackerrank.com/challenges/minimum-loss/problem
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumLoss function below.
    /*
    Idea:
    Scan through the input array
    - Get the current price
    - Get the smallest higher value than current price in the treeSet (close)
    - If (treeSet not empty) && (close != null) => update minLoss if possible
    */
    static long minimumLoss(long[] price) {
        TreeSet<Long> treeSet = new TreeSet<>();
        long minLoss = Long.MAX_VALUE;
        for(int i = 0; i < price.length; i++) {
            Long currPrice = price[i];
            Long close = treeSet.higher(currPrice);
            if(!treeSet.isEmpty() && close != null) { 
                long loss = close - currPrice;
                minLoss = Math.min(minLoss, loss);
            }
            treeSet.add(currPrice);
        }
        return minLoss;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] price = new long[n];

        String[] priceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long priceItem = Long.parseLong(priceItems[i]);
            price[i] = priceItem;
        }

        long result = minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
