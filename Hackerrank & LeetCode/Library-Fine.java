/*
https://www.hackerrank.com/challenges/library-fine/problem
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the libraryFine function below.
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        int fine = 0;
        if( (y1 < y2) || ((d1 <= d2) && (m1 == m2) && (y1 == y2)) || (m1 < m2) && (y1 == y2)) { // on time
            fine = 0;
        } else if ((d1 > d2) && (m1 == m2) && (y1 == y2)) { // diff day, same month
            fine = 15 * (d1 - d2);
        } else if (m1 > m2 && y1 == y2) { // diff month, same year
            fine = 500 * (m1 - m2);
        } else if (y1 > y2) { // diff year
            fine = 10000;
        } else {
            fine = -1;
        }
        return fine;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] d1M1Y1 = scanner.nextLine().split(" ");

        int d1 = Integer.parseInt(d1M1Y1[0]);

        int m1 = Integer.parseInt(d1M1Y1[1]);

        int y1 = Integer.parseInt(d1M1Y1[2]);

        String[] d2M2Y2 = scanner.nextLine().split(" ");

        int d2 = Integer.parseInt(d2M2Y2[0]);

        int m2 = Integer.parseInt(d2M2Y2[1]);

        int y2 = Integer.parseInt(d2M2Y2[2]);

        int result = libraryFine(d1, m1, y1, d2, m2, y2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
