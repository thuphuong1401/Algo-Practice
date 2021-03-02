/*

Big idea: range of min capacity is [0, total] where total = total of all vessel capacities
Use binary search to find min

https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2408
*/

import java.util.*;
import java.io.*;

class MyCode {
    
    private static int n, m;
    private static int[] arr;
    private static int high;
    private static int low;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()) {
            high = 0;
            low = 0;
            n = scan.nextInt();
            m = scan.nextInt();
            arr = new int[n];
            for(int i = 0; i < n; i++) {
                int x = scan.nextInt();
                arr[i] = x;
                high += x;
            }
            int ans = binarySearch();
            System.out.println(ans);
        }   
	}
    
    private static int binarySearch() {
        int res = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(fillable(mid)) {
                high = mid - 1;
                res = mid;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
    
    private static boolean fillable(int cap) {
        long currCap = 0;
        int numContainer = 0;
        for(int i = 0; i < n; i++) {
            int currVessel = arr[i];
            if(currVessel > cap) {
                return false;
            }
            if(currCap + currVessel > cap) {
                currCap = 0;
            }
            if(currCap == 0) {
                numContainer++;
            }
            if(numContainer > m) {
                return false;
            }
            currCap += currVessel;
        }
        return true;
    }
    

    
    
    
}



