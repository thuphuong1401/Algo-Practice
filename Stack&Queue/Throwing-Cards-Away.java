/*
https://www.urionlinejudge.com.br/judge/en/problems/view/1110
*/
import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> input = new ArrayList<>();
    while(scan.hasNext()) {
      input.add(scan.nextInt());
    }
    
    for(int n : input) {
      Queue<Integer> deck = new LinkedList<>();
      ArrayList<Integer> discarded = new ArrayList<>();
      
      if(n == 0) {
        continue;
      }
      
      for(int j = 1; j <= n; j++) {
        deck.add(j);
      }
      
      while(deck.size() >= 2) {
        int discarded1 = deck.poll();
        discarded.add(discarded1);
        deck.add(deck.poll());
      }
      
      System.out.print("Discarded cards:");
      for (int i = 0; i < n - 1; i++) {
        if (i != 0) {
          System.out.print(",");
        }
        System.out.format(" %d", discarded.get(i));
      }
      System.out.println();
      System.out.format("Remaining card: %d\n", deck.poll());
    }
  }
}
