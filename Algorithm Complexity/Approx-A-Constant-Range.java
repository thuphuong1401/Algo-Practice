/*
https://codeforces.com/problemset/problem/602/B
*/

import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

public class Main {
  
 static final int MAX = (int)1e5 + 5;
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int[] datapts = new int[N];
    for(int i=0; i<N; i++) {
      datapts[i] = scan.nextInt();
    }
  	
	
    int maxRange = 0;
    int[] freq = new int[MAX];
    int j = 0;
    int distinct = 0;
    
    for(int i=0; i<N; i++) {
      
        // freq=0 => never seen this datapts
    	if(freq[datapts[i]] == 0) {
          distinct++;
        }  
      
      freq[datapts[i]]++;
			
      // have reached more than 2 distinct elements, start trimming
      while(j<N && distinct > 2) {
        if(freq[datapts[j]] == 1) {
          distinct--;
        }
        freq[datapts[j]]--;
        j++;
      }
      
      maxRange = Math.max(maxRange, i-j+1);
      //System.out.println(maxRange);
    }
    System.out.println(maxRange);
  }
}
