/*
https://onlinejudge.org/external/104/10489.pdf
*/
import java.util.*;
import java.io.*;

class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-- > 0) {
            int n = scan.nextInt();
            int b = scan.nextInt();
            int r = 0;
            for(int i = 0; i < b; i++) {
                int prod = 1;
                int k = scan.nextInt();
                for(int j = 1; j < k; j++) {
                    int x = scan.nextInt();
                    prod *= x;
                    prod %= n;
                }
                int l = scan.nextInt();
                prod *= l;
                prod %= n;
                
                r += prod;
            }    
            System.out.println(r % n);
        } 
	}
}
