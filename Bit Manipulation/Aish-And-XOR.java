/*
https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/aish-and-xor-2/
*/

import java.util.*;
import java.io.*;

class MyCode {
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        // number of 1's so far
        int[] numOnes = new int[n];
        numOnes[0] = (scan.nextInt() == 1) ? 1 : 0;
        for(int i = 1; i < n; i++) {
            int curr = scan.nextInt();
            if(curr == 0) {
                numOnes[i] = numOnes[i-1];
            } else {
                numOnes[i] = numOnes[i-1] + 1;
            }
        }        
        
        int query = scan.nextInt();
        
        for(int i = 0; i < query; i++) {
            int l = scan.nextInt()-1;
            int r = scan.nextInt()-1;
            
            // number of 0's in l->r
            int range = r - l + 1;
            
            int numUnsetBits = 0;
            
            if(l-1 < 0) {
                numUnsetBits = range - numOnes[r];
            } else {
                numUnsetBits = range - (numOnes[r] -  numOnes[l-1]);
            }
            
            
            // xor l -> r. Odd num of 1's => xor = 1. Even num of 1's => xor = 0
            int xor = 0;
            int numSetBits = range - numUnsetBits;
            if(numSetBits % 2 == 0) {
                xor = 0;
            } else {
                xor = 1;  
            } 
            
            System.out.println(xor + " " + numUnsetBits);
            
        }
	}
}



