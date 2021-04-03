import java.util.*;
import java.io.*;

public class Main {
	static int MAX = (int)(1e5);
    
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int l = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        
        int[] count = new int[MAX+1];
        for(int i : arr) {
            count[i]++;
        }    
        
        int[] suffixCount = new int[MAX+1];
        for(int i = 0; i <= MAX; i++) {
            suffixCount[i] = count[i];
        }
        
        for(int i = MAX-1; i >= 0; i--) {
            suffixCount[i] += suffixCount[i+1];         
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = MAX; i > 0; i--) {
            if(suffixCount[i] + Math.min(count[i-1], l) >= i) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
	}
}
