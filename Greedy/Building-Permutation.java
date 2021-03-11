/*
https://codeforces.com/problemset/problem/285/C
*/
import java.util.*;
import java.io.*;

class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        long minMoves = 0;
        for(int i = 0; i < n; i++) {
            minMoves += Math.abs(i - arr[i] + 1);
        }
        System.out.println(minMoves);
    }
}

