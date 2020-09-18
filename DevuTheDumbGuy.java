import java.util.Collections;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
  	int x = scan.nextInt();
    ArrayList<Integer> time = new ArrayList<>();
    
    for(int i=0; i<n; i++) {
      time.add(scan.nextInt());
    }
    
    Collections.sort(time);
    
    long totalTime = 0;
    for(int i=0; i<n ; i++) {
      if(x>1) {
        totalTime += 1L * time.get(i) * x--;
      } else {
      totalTime += time.get(i);
      }
    }
    
    System.out.println(totalTime);
    
  } 
}
