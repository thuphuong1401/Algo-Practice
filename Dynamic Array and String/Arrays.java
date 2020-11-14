/*
https://codeforces.com/problemset/problem/572/A
*/
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String firstLine = scan.nextLine();
    String secondLine = scan.nextLine();
    String thirdLine = scan.nextLine();
    String forthLine = scan.nextLine();
    
    String[] first = firstLine.split(" ");
    int aLength = Integer.parseInt(first[0]);
    int bLength = Integer.parseInt(first[1]);
    String[] second = secondLine.split(" ");
    int m = Integer.parseInt(second[0]);
    int k = Integer.parseInt(second[1]);
    String[] third = thirdLine.split(" ");
    String[] forth = forthLine.split(" ");
    
    int[] a = new int[aLength];
    int[] b = new int[bLength];
    
    for(int i = 0; i < aLength; i++) {
      a[i] = Integer.parseInt(third[i]);
    }
    
    for(int j = 0; j < bLength; j++) {
      b[j] = Integer.parseInt(forth[j]);
    }
    
    if (a[m-1] < b[bLength - k]) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
    
    
  }
}
