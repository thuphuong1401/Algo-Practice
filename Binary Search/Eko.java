/*
https://www.spoj.com/problems/EKO/cstart=40
*/
import java.io.*;
import java.util.*;

class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long m = scan.nextInt();
        int[] tree = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int x = scan.nextInt();
            tree[i] = x;
            max = Math.max(max, x);        
        }
        // Binary search
        int left = 0;
        int right = max;
        
        int res = 0;
        while(left <= right) {
            int mid = left + (right - left)/2;
            long amount = 0;
            // calculate the amount of wood got by cutting trees at int mid
            for(int i = 0; i < n; i++) {
                amount += Math.max(0, tree[i] - mid);      
            }
            if(amount < m) {
                right = mid - 1;
            } else { // >= only
                res = mid; // save the previous result before the next search iteration
                left = mid + 1;
            }
        }
        System.out.println(res);
	}
}
