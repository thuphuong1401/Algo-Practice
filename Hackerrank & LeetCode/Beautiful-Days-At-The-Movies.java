/*
https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int numBeautiful = 0;
        for(int d = i; d <= j; d++) {
            if(Math.abs(d - reverse(d)) % k == 0) {
                numBeautiful++;
            }
        }
        return numBeautiful;
    }
    
    static int reverse(int d) {
        int reverse = 0;
        int length = Integer.toString(d).length();
        int counter = length-1; 
        while(counter >= 0) {
            reverse += (d%10) * Math.pow(10, counter); 
            counter--;
            d = d/10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        int j = scan.nextInt();
        int k = scan.nextInt();
        //int y = 20;
        //System.out.println(reverse(y));
        int x = beautifulDays(i, j, k);
        System.out.println(x);
    }
    
}
