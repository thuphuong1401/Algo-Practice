/*
https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/mattey-multiplication-6/
*/

import java.util.*;
import java.io.*;

class MyCode {
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        
        while(numTestCases-- > 0) {
            long n = scan.nextLong();
            long m = scan.nextLong();
                    
            // by derivation, p_i are the position of 1 bit in M            
            List<Integer> positionOfOneBit = new ArrayList<>();
            
            int pos = 0;
            
            while(m != 0) {
                if((m & 1L) == 1) { // last binary digit of m is 1
                    positionOfOneBit.add(pos);
                }
                m >>= 1;
                pos++;
            }
            
            for(int i = positionOfOneBit.size() - 1; i >= 0; i--) {
                if(i != positionOfOneBit.size() - 1) {
                    System.out.print(" + ");
                }
                System.out.printf("(%d<<%d)", n, positionOfOneBit.get(i));
            }
            System.out.println();
        
        }
    
    
    }
}


