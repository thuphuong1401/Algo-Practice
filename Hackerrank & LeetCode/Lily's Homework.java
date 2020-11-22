/*
https://www.hackerrank.com/challenges/lilys-homework/problem
Brute force solution - Got time limit exceeded
Runtime: O(n^2)
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    /*
    Brute force solution
    Idea: 
    1. Sort the given array
    2. Compare arr pre-sort and sorted element-wise. If diff, increment count, then swap
    3. Get min of step 2 for both ascending and descending sorted array
    */
    static int lilysHomework(int[] arr) {
        int[] copyOfArr = Arrays.copyOfRange(arr, 0, arr.length);
        int minAsc = findMinSwapAsc(arr);
        int minDesc = findMinSwapDesc(copyOfArr);
        int answer = Math.min(minAsc, minDesc);
        return answer;
    }
    
    static int findMinSwapAsc(int[] arr) {
        int answer = 0;
        int n = arr.length;
        int[] temp = Arrays.copyOfRange(arr, 0, n);
        Arrays.sort(temp);
        for(int i = 0; i < n; i++) {
            if(arr[i] != temp[i]) {
                answer++;
                swap(arr, i, getIndex(arr, temp[i]));
            }
        }
        return answer;
    }

    static int findMinSwapDesc(int[] arr) {
        int answer = 0;
        int n = arr.length;
        int[] temp = Arrays.copyOfRange(arr, 0, n);
        Arrays.sort(temp);
        reverse(temp);
        for(int i = 0; i < n; i++) {
            if(arr[i] != temp[i]) {
                answer++;
                swap(arr, i, getIndex(arr, temp[i]));
            }
        }
        return answer;
    }
    
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static int getIndex(int[] arr, int x) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
    
    // helper reverse function
    public static void reverse(int[] input) {
        if(input == null || input.length <= 1) {
            return;
        }
        for(int i = 0; i < input.length/2; i++) {
            int temp = input[i];
            input[i] = input[input.length-1-i];
            input[input.length-1-i] = temp;
        }
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

        int result = lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
