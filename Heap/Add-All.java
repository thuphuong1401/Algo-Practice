/*
https://www.programmersought.com/article/8632323383/
*/

import java.io.*;
import java.util.*;

class MyCode {
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    while(true) {
      int numCases = scan.nextInt();
      if(numCases == 0) {
        break;
      }
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      for(int i = 0; i < numCases; i++) {
        pq.add(scan.nextInt());
      }
      long ans = 0;
      while(pq.size() >= 2) {
        int x = pq.remove();
        int y = pq.remove();
        int currSum = x + y;
        ans += currSum;
        pq.add(currSum);
      }
      
      System.out.println(ans);
      
    }
        
    
    
  }
  
}
