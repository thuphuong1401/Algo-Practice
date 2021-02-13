/*
https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=670
*/

import java.util.*;
import java.io.*;

class MyCode {
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        while(numTestCases-- > 0) {
            int n = scan.nextInt();
            int h = scan.nextInt();
            char[] str = new char[n];
            backtracking(str, 0, n, h);
            System.out.println();
        }    
	}
    
    public static void backtracking(char[] str, int i, int n, int h) {
        if(i == n) {
            if(h == 0) {
                for(char c : str) {
                    System.out.print(c);
                }
                System.out.println();
            }
            return;
        }
        
        str[i] = '0';
        backtracking(str, i+1, n, h);
        str[i] = '1';
        backtracking(str, i+1, n, h-1);
        
        
    }
}



