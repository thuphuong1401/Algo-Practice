/*
https://www.hackerrank.com/challenges/sherlock-and-squares/problem
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the squares function below.
    static int squares(int a, int b) {
        int count = 0;
        int sqrtA = (int) Math.sqrt(a);
        int sqrtB = (int) Math.sqrt(b);
        for(int i = sqrtA; i <= sqrtB; i++) {
            int squared = i*i;
            if(a <= squared && squared <= b) {
                count++;
            }
        }
        return count;         
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
