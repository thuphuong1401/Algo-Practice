/*
Intelligent Girl - Very Easy - DP - Hackerrank
https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/intelligent-girl-1/description/
*/

import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        char[] temp = s.toCharArray();
        int[] input = new int[temp.length];
        for(int i = 0; i < temp.length; i++) {
            int x = Character.getNumericValue(temp[i]);
            input[i] = x;
        }

        int[] dp = new int[input.length];
        dp[input.length-1] = (input[input.length - 1] % 2 == 0 ? 1 : 0);
        for(int i = dp.length - 2; i >= 0; i--) {
            if(input[i] % 2 == 0) {
                dp[i] = dp[i+1] + 1;
            } else {
                dp[i] = dp[i+1];
            }
        }

        for(int j = 0; j < dp.length; j++) {
            System.out.print(dp[j] + " ");
        }
        
    }
}
