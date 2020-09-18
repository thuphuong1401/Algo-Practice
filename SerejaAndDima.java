import java.util.Scanner;
import java.lang.Math;

// Sereja and Dima - Codeforces https://codeforces.com/problemset/problem/381/A

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] cards = new int[n];
    int sereja = 0;
    int dima = 0;
    
    for(int i=0; i<n; i++) {
    	cards[i] = scan.nextInt();  
    }
    
    int rightmost = n-1;
    int leftmost = 0;
    int turn = 0;
    int temp = 0;
    
    while(leftmost <= rightmost) {
      temp = Math.max(cards[rightmost], cards[leftmost]);
      if (turn%2 == 0) {
        sereja += temp;
      } else {
        dima += temp;
      }
      
     	if(temp == cards[rightmost]) {
        rightmost--;
      } else {
        leftmost++;
      }
      turn++;
    }
   
    System.out.println(sereja + " " + dima);
  }
}
