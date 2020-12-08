/*
https://onlinejudge.org/external/106/10611.pdf
*/
import java.util.*;
import java.io.*;

class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] height = new long[n];
        for(int i = 0; i < n; i++) {
            height[i] = scan.nextInt();
        }
    
        int q = scan.nextInt();
        
        for(int i = 0; i < q; i++) {
            long query = scan.nextInt();
            String answer = "";
            
            int j;
            long ansTallest = -1;
            
            for(j = 0; j < n; j++) {
                if (height[j] < query) {
                    ansTallest = height[j]; // get last element smaller than query
                }
                else {
                    break;
                }      
            }        
            long ansShortest = -1;
            for(int k = j; k < n; k++) {
                if(height[k] > query) {
                    ansShortest = height[k]; // get first element larger than query
                    break;
                } 
            }
            
            
            if(ansTallest == -1) {
                answer += "X";
            } else {
                answer += Long.toString(ansTallest);
            }
            
            answer += " ";
            
            if(ansShortest == -1) {
                answer += "X";
            } else {
                answer += Long.toString(ansShortest);
            }
            
            System.out.println(answer);
            
        }        
	}
}


