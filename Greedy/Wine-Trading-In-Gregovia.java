/*
http://poj.org/problem?id=2940
*/

// TLE solution
import java.util.*;
import java.io.*;

class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            int n = scan.nextInt();
            if(n == 0) {
                return;
            }
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
            
            long res = 0;
            
            for(int i = 0; i < n; i++) {
                if(arr[i] > 0) {
                    for(int j = 0; j < n; j++) {
                        if(arr[j] < 0) {
                            int temp = Math.min(arr[i], -arr[j]);
                            arr[i] -= temp;
                            arr[j] += temp;
                            res += (long)temp*Math.abs(j - i);
                          
                        }
                    }    
                }
            }
            
            System.out.println(res);
            
        }
	 }
}


// Calculate prefixSum => take absolute value, sum += Math.max(value)
import java.util.*;
import java.io.*;

class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            int n = scan.nextInt();
            if(n == 0) {
                return;
            }
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
            
            long res = 0;
            long curr = 0;
            int[] prefixSum = new int[n];
            prefixSum[0] = arr[0];
            
            for(int i = 1; i < n; i++) {
                prefixSum[i] = prefixSum[i-1] + arr[i];        
            }
            
            for(int num : prefixSum) {
                res += Math.abs(num);
            }
            
            System.out.println(res);
            
        }
	 }
}






