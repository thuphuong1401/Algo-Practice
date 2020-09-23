import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] arr = new int[n];
    int[] temp_arr = new int[n];
    
    for(int i=0; i<n; i++) {
      arr[i] = scan.nextInt();
      temp_arr[i] = arr[i];
    }
    
    Arrays.sort(arr);
    int l = 0, r = 0;
    
    // Find l
    for(int i=0; i<n; i++) {
      if(temp_arr[i] != arr[i]) {
        l = i;
        break;
      }
    }
    
    // Find r 
    for(int i = n-1; i>=0; i--) {
      if(temp_arr[i] != arr[i]) {
        r = i;
        break;
      }
    }
    
    // Reverse l, r
    for(int i = l, j=r; i<j; i++, j--) {
      int temp = temp_arr[i];
      temp_arr[i] = temp_arr[j];
      temp_arr[j] = temp;
    }
    
    
    // Compare to sorted arr
    for(int i = 0; i<n; i++) {
      if(temp_arr[i] != arr[i]) {
        System.out.println("no");
        return;
      }
    }
    
    System.out.println("yes");
    int t1 = l+1;
    int t2 = r+1;
    System.out.println(t1 + " " + t2);
    
  }
}
