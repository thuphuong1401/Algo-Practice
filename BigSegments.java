import java.util.Scanner;
import java.util.ArrayList;

public class BigSegments {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int numSeg = scan.nextInt();
    int min = Integer.MAX_VALUE;
    int max = 0;
    int curr = 0;
    ArrayList<Integer> track = new ArrayList<>();
    
    while(scan.hasNext()) {
      curr = scan.nextInt();
      
      if(curr < min) {
        min = curr;
      }
      if(curr > max) {
        max = curr;
      }
      track.add(curr);
    }
    
    for(int i = 0; i < track.size(); i+=2) {
    	if(track.get(i) <= min && track.get(i+1) >= max) {
        int x = i/2 + 1;
        System.out.println(x);
        System.exit(0);
      } 
    }
    System.out.println("-1");
    }
  }
