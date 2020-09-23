import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    ArrayList<Integer> temp = new ArrayList<>();
    ArrayList<Integer> rating = new ArrayList<>();
    int[] rankings = new int[2010];
    
    for(int i=0; i<n; i++) {
      int x = scan.nextInt();
      temp.add(x);
      rating.add(x);
    }
    
    Collections.sort(temp, Collections.reverseOrder());
    for(int i=0; i<n; i++) {
      if(rankings[temp.get(i)] == 0) {
        rankings[temp.get(i)] = i+1;
      }
    }
    
    for(int i=0; i<rating.size(); i++) {
      System.out.print(rankings[rating.get(i)] + " ");
    }
  }
}
