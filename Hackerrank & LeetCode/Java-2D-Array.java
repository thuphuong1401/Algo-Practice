/*
https://www.hackerrank.com/challenges/java-2d-array/problem
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    static int maxHourGlassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0; i <= 3; i++) {
            for(int j = 0; j <= 3; j++) {
                currSum = 0;
                currSum += arr[i][j];
                currSum += arr[i][j+1]; 
                currSum += arr[i][j+2];
                currSum += arr[i+1][j+1];
                currSum += arr[i+2][j];
                currSum += arr[i+2][j+1];
                currSum += arr[i+2][j+2];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        
        int maxSum = maxHourGlassSum(arr);
        System.out.println(maxSum);

        scanner.close();
    }
}
