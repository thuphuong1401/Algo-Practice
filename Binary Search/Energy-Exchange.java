/*
https://codeforces.com/problemset/problem/68/B
*/
import java.util.*;
import java.io.*;

class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        int energy = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
            energy += arr[i];
        }
        
        double low = 0;
        double high = 10000;
        double tol = 1e-6;
        double mid = 0;
        
        while(low + tol <= high) {
            mid = low + (high - low)/2;
            double totalLoss = 0;
            for(int i = 0; i < n; i++) {
                if(arr[i] - mid >= 0) {
                    totalLoss += (arr[i] - mid);
                }
            }
            totalLoss = totalLoss * k / 100;
            if(energy - totalLoss < n * mid) {
                high = mid;
            } else {
                low = mid;
            }
        }
        System.out.println(mid);   
	}
}
