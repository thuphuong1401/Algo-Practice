/*
Given two integers m and n, loop repeatedly through an array of m and remove each nth element. Return the last element left. 
(If m = 7 and n = 4, then begin with the array 1 2 3 4 5 6 7 and remove, in order, 4 1 6 5 7 3 and return 2.)
*/
import java.util.*;
import java.io.*;

class MyCode {
    
	public static void main (String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int m = 7;
        int n = 4;
        solve(arr, m, n);
    }
    
    private static int increment(int i, int m) {
        i++;
        if(i == m) {
            i = 0;
        }
        return i;
    }
    
    private static void solve(int[] arr, int m, int n) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> deleted = new HashSet<>();
        int currCount = 1;
        int i = 0;
        
        while(deleted.size() < m) {
            if(deleted.contains(i)) {
                i = increment(i, m);
            } else {
                if(currCount < n) {
                    currCount++;
                    i = increment(i, m);
                } else {
                    deleted.add(i);
                    ans.add(arr[i]);
                    i = increment(i, m);
                    currCount = 1;
                }
            }
        }
        
        System.out.println(ans);
        
    }
    
}
