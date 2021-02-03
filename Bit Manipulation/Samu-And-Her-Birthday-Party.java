/*
https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/samu-and-her-birthday-party-1/
*/
import java.util.*;
import java.io.*;

class MyCode {
    static int k;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        while(numTestCases-- > 0) {
            int n = scan.nextInt();
            k = scan.nextInt();
            
            String[] s = new String[n];
            
            for(int i = 0; i < n; i++) {
                s[i] = scan.next();    
            }
            
            int smallest = getSmallestSubset(s);
            System.out.println(smallest);
        }
	}
    
    
    public static int getSmallestSubset(String[] s) {
        int min = Integer.MAX_VALUE;
        for(int n = 1; n < Math.pow(2, k); n++) {
            int curr = n;
            for(int i = 0; i < s.length; i++) {
                int strToInt = Integer.parseInt(s[i], 2);
                if((curr & strToInt) == 0) {
                    break;
                }
                if(i == s.length - 1) { // bigger number != more 1 bits
                    int currMin = Integer.bitCount(curr);
                    min = Math.min(min, currMin);
                }
            }
        }
        return min;
    }
    
}



