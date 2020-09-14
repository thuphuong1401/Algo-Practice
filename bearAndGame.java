import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class bearAndGame {
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);
    ArrayList<String> input = new ArrayList<>();
    while(scan.hasNextLine()) {
      String read = scan.nextLine();
      if (read == null || read.isEmpty()) {
        break;
      }
      input.add(read);
    }
    
    int numInterestingMin = Integer.parseInt(input.get(0));
    String str = input.get(1);
    int watchGame = 0;
    
    // Add 0 to the beginning
    String[] minOccur = str.split(" ");
    ArrayList<Integer> occur = new ArrayList<>();
    occur.add(0);
    for (int i = 0; i < minOccur.length; i++) {
      int temp = Integer.parseInt(minOccur[i]);
      occur.add(temp);
    }
    
    // Logic here
    for (int j = 0; j < occur.size()-1; j++) {
      int diff = occur.get(j+1) - occur.get(j);
      
      if (diff <= 15) {
        watchGame = occur.get(j+1);
      } else {
        watchGame = occur.get(j) + 15;
        break;
      }
   
    	if (occur.get(occur.size()-1) < 75) { 
    		watchGame = occur.get(occur.size() - 1) + 15;
    	} else {
      	watchGame = 90;
    	}
      
    }
    System.out.println(watchGame);
  }
}
