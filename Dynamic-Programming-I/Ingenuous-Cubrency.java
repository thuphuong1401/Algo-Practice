/*
https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=2078
*/

import java.util.*;
import java.io.*;

class MyCode {
    static int MAX = 10001;
    static long dp[];
    
    public static void main (String[] args) {
        dp = new long[MAX];
        cubeCoinChange();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()) {
            int n = scan.nextInt();
            System.out.println(dp[n]);
        }            
    }
    
    private static void cubeCoinChange() {
        dp[0] = 1;
        for(int i = 1; i <= 21; i++) {
            int cube = i*i*i;
            for(int j = cube; j < MAX; j++) {
                dp[j] += dp[j-cube];
            }
        }
    }  
      
}



