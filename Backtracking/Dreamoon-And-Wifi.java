/*
https://codeforces.com/problemset/problem/476/B
*/

import java.util.*;
import java.io.*;

class MyCode {
    public static String s1;
    public static String s2;
    public static int originalPos;
    public static int totalCases;
    public static int correctCases;

    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        s1 = scan.next();
        s2 = scan.next();
        originalPos = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == '+') {
                originalPos++;
            } else {
                originalPos--;
            }         
        }
        
        backtrack(0, 0);
        
        double res = (double)correctCases / (double)totalCases;
        System.out.println(res);
        
	}
    
    
    public static void backtrack(int i, int position) {
        if(i == s1.length()) {
            if(position == originalPos) {
                correctCases++;
            }
            totalCases++;
            return;
        }
        
        if(s2.charAt(i) != '-') {
            backtrack(i+1, position+1);
        }
        
        if(s2.charAt(i) != '+') {
            backtrack(i+1, position-1);
        }
        
    }
    
}

