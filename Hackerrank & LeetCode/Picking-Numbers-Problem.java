/*
https://www.hackerrank.com/challenges/picking-numbers/problem
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        
        int max = 0;
        Collections.sort(a);
        for(int i = 0; i < a.size()-1; i++) {
            int counter = 1;
            int currLowest = a.get(i);
            int currHighest = a.get(i);
            for(int j = i+1; j < a.size(); j++) {
                currLowest = Math.min(currLowest, a.get(j));
                currHighest = Math.max(currHighest, a.get(j));
                if(currHighest - currLowest > 1) {
                    break;
                } else {
                    counter++;
                }
            } 
            max = Math.max(max, counter);
        }
        return max;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
