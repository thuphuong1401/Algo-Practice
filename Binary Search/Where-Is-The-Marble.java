/*
https://www.urionlinejudge.com.br/judge/en/problems/view/1025
*/
import java.util.*;
import java.io.*;

class MyCode {
    
    static int n, q;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCase = 1;    
        while(true) {
            n = scan.nextInt();
            q = scan.nextInt();
            if(n == 0 && q == 0) {
                break;
            }
            int[] marbles = new int[n];
            for(int i = 0; i < n; i++) {
                marbles[i] = scan.nextInt();
            }

            Arrays.sort(marbles);
            
            System.out.println("CASE# " + numCase + ":");
            for(int i = 0; i < q; i++) {
                int query = scan.nextInt();
                int ans = bsFirst(marbles, 0, n-1, query);
                if(ans == -1) {
                    System.out.println(query + " not found");
                    continue;
                }
                System.out.println(query + " found at " + (ans+1));
            }
            numCase++;
        }
	}
    
    public static int bsFirst(int[] a, int left, int right, int x) {
        if(left <= right) {
            int mid = left + (right - left)/2;
            if((mid == left || x > a[mid-1]) && a[mid] == x) {
                return mid;
            } else if (x > a[mid]) {
                return bsFirst(a, (mid+1), right, x);
            } else {
                return bsFirst(a, left, (mid-1), x);
            }
        }
        return -1;
    }
    
}
