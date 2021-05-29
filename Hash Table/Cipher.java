/*
https://www.hackerrank.com/challenges/cipher/problem
*/
import java.util.*;
import java.io.*;

class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        String s = scan.next();
        
        int[] ans = new int[n];
        int x = 0;
        for(int i = 0; i < n; i++) {
            if(i >= k) {
                x ^= ans[i-k];
            }
            ans[i] = (s.charAt(i) - '0') ^ x;
            x ^= ans[i];
        }
        
        for(int i : ans) {
            System.out.print(i);
        }
	}
}
