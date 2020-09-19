import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] claw = new int[n];
    for(int i=0; i<n; i++) {
      claw[i] = scan.nextInt();
    }
    
    int killed=0; // count number of people killed
    int j = n-1;
    int furthestReaching = 0;
    for(int i = n-1; i >= 0; i--) {
      j = Math.min(i,j);
      furthestReaching = Math.max(0, i-claw[i]);
      
      // some people killed but not counted yet
      while(j > furthestReaching) {
        killed += (j-furthestReaching);
        j = furthestReaching;
      }
      
    }
    System.out.println(n-killed);
    
  } 
}
