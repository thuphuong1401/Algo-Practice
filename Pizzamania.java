/*
https://www.spoj.com/problems/OPCPIZZA/cstart=20
*/
import java.util.*;
import java.io.*;

// HashMap
class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        for(int i = 0; i < numTestCases; i++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int numPairs = 0;
            
            // (value, index)
            Map<Integer, Integer> map = new HashMap<>();
            
            for(int j = 0; j < n; j++) {
                int x = scan.nextInt();
                if(map.containsKey(m-x)) { // O(1)                  
                    numPairs++;        
                }
                map.put(x, j);
            }
            System.out.println(numPairs);
        }
	}
}


// HashSet

import java.util.*;
import java.io.*;

class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        for(int i = 0; i < numTestCases; i++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int numPairs = 0;
            
            Set<Integer> set = new HashSet<>();
            
            for(int j = 0; j < n; j++) {
                int x = scan.nextInt();
                if(set.contains(m-x)) {                   
                    numPairs++;        
                }
                set.add(x);
            }
            System.out.println(numPairs);
        }
	}
}
