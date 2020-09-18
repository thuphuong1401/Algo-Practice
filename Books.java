import java.util.Scanner;
import java.lang.Math;

/*
Books - Codeforces: https://codeforces.com/problemset/problem/279/B
*/


public class Main {
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int free = scan.nextInt();
    int[] book = new int[n];
    
    for(int i=0; i<n; i++) {
      book[i] = scan.nextInt();
    }
    
    int maxNumBooks = 0;
    
    for(int i=0; i<n ; i++) {
      int j=i;
      int currSumMin = 0;
      int currBook = 0;
      
      
      while(currSumMin <= free && j<n) {
        currSumMin += book[j];
        if(currSumMin > free) break;
        currBook++;
        j++;
      }
      
      maxNumBooks = Math.max(currBook, maxNumBooks);
    }
    System.out.println(maxNumBooks);
    
  }
}
