import java.util.Scanner;
import java.util.ArrayList;

/*
Array on Codeforces: https://codeforces.com/problemset/problem/224/B
*/
public class Main {
    static final int MAX = (int)1e5 + 5;
    static int freq[] = new int[MAX];
     
    public static void main(String[] args) {
 			Scanner sc = new Scanner(System.in);
 			int n = sc.nextInt();
 			int k = sc.nextInt();
 			int[] a = new int[n];
      
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      
      int numofUniques = 0;
      int j = 0;
      
      for(int i=0; i<n; i++) {
        
        // If encounter a distinct number
      	if(freq[a[i]] == 0) {
          numofUniques++;
        } 
        
        // Increment frequency of a[i]
        freq[a[i]]++;
        
        // When have found R, trimmed the array for minimal
        while(numofUniques == k) {
          freq[a[j]]--;
          
          // First time encounter a unique element
          // Go past this point will "harm" the number of distinct elements
          if(freq[a[j]]==0) {
            int temp1 = j+1;
            int temp2 = i+1;
            System.out.println(temp1 + " " + temp2);
            System.exit(0);
          }
          j++;
        }
      }
        System.out.print("-1 -1");
    }
}
