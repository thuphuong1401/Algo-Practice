/*
https://codeforces.com/problemset/problem/262/B
*/
import java.util.*;
import java.io.*;

class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        int minAbs = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int x = scan.nextInt();
            arr[i] = x;
            minAbs = Math.min(minAbs, Math.abs(x));    
        }
        long total = 0;
        for(int i = 0; i < n && k > 0; i++) { 
            if(arr[i] < 0) {
                arr[i] = -arr[i];
                k--;
            }
        }
        
        for(int i = 0; i < n; i++) {
            total += arr[i];
        }
        
        if(k > 0) {
            if(k % 2 == 1) {
                total += -2 * minAbs;    
            }
        }
        System.out.println(total);
	}
}


