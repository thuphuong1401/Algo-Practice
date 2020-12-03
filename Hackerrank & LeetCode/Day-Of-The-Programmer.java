/*
https://www.hackerrank.com/challenges/day-of-the-programmer/problem
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        String answer = "";
        if(1700 <= year && year <= 1917) {
            if(year % 4 == 0) {
                answer = "12.09." + year;
            } else {
                answer = "13.09." + year;
            }
        } else if (year == 1918) {
            answer = "26.09.1918";
        } else if (1919 <= year && year <= 2700) {
            if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                answer = "12.09." + year;
            } else {
                answer = "13.09." + year;
            }
        } else {
            answer = "Invalid";
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
