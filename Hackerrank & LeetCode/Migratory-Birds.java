/*
https://www.hackerrank.com/challenges/migratory-birds/problem
Brute-force version
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        // get freq => get most freq => get lowest
        int MAX = (int) 1e6;
        int[] count = new int[MAX];
        for(int i = 0; i < arr.size(); i++) {
            count[arr.get(i)]++;
        }
        int maxCount = Integer.MIN_VALUE;
        for(int i = 0; i < MAX; i++) {
            maxCount = Math.max(maxCount, count[i]);
        }
        List<Integer> maxFreq = new ArrayList<>();
        for(int i = 0; i < MAX; i++) {
            if(count[i] == maxCount) {
                maxFreq.add(i);
            }
        }
        int answer = maxFreq.get(0);
        for(int i = 0; i < maxFreq.size(); i++) {
            answer = Math.min(answer, maxFreq.get(i));
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr.add(arrItem);
        }

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
