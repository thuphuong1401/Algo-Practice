/*
https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
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

/*
Idea: 
- Create a rank array of scores (to take account of equal score -> equal rank)
- Loop through Alice score array:
    + For every score, do binary search on the score array. Return index 
    + Rank is rank[index]
*/
public class Solution {
    
    static int n, m;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int[] scores = new int[n];
        for(int i = 0;  i < n; i++) {
            scores[i] = scan.nextInt();
        }
        m = scan.nextInt();
        int[] alice = new int[m];
        for(int i = 0; i < m; i++) {
            alice[i] = scan.nextInt();
        }
        int[] answer = climbingLeaderboard(scores, alice);
        for(int k : answer) {
            System.out.println(k);
        }
    }

    public static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] res = new int[m];
        int[] rank = new int[n];
        
        rank[0] = 1;
        for(int i = 1; i < n; i++) {
            if(scores[i] == scores[i-1]) {
                rank[i] = rank[i-1];
            } else {
                rank[i] = rank[i-1] + 1;
            }
        }
        
        for(int i = 0; i < m; i++) {
            int aliceScore = alice[i];
            if(aliceScore > scores[0]) { 
                res[i] = 1;
            } else if(aliceScore < scores[n-1]) {
                res[i] = rank[n-1] + 1;
            } else {
                int index = binarySearch(scores, aliceScore);
                res[i] = rank[index];
            }
        }
        return res;
    }
    
    public static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length-1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(a[mid] == key) {
                return mid;
            } else if(a[mid] < key && key < a[mid-1]) {
                return mid;
            } else if(a[mid] > key && key >= a[mid + 1]) {
                return mid+1;
            } else if(a[mid] < key) {
                high = mid - 1;
            } else if(a[mid] > key) {
                low = mid + 1;
            }
        }
        return -1;
    }
    
    
}
