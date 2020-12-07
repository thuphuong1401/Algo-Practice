/*
https://www.hackerrank.com/challenges/java-negative-subarray/problem
*/

/*
Brute-force solution: 3 loops, O(n^3)
*/
import java.io.*;
import java.util.*;

public class Solution {
    static int n;
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();        
        }
        int answer = numNegativeSubarray(arr);
        System.out.println(answer);
    }
    
    public static int numNegativeSubarray(int[] arr) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int currSum = 0;
                int k = i;
                while(k <= j) {
                    currSum += arr[k];    
                    k++;
                }
                if(currSum < 0) {
                    count++;
                }
            }
        }
        return count;
    }   
}


/*
Still brute-force, but this takes O(n^2). In fact I don't think there's an O(n) solution
*/
import java.io.*;
import java.util.*;

public class Solution {
    
    static int n;
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }    
        int answer = countNegativeSubarray(arr);
        System.out.println(answer);
    }
    
    public static int countNegativeSubarray(int[] arr) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            int currSum = 0;
            for(int j = i; j < n; j++) {
                currSum += arr[j];
                if(currSum < 0) {
                    count++;
                }
            }
        }
        return count;
    }
    
}
