/*
https://codeforces.com/problemset/problem/387/B
*/

import java.util.Scanner;
import java.util.ArrayList;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>(), b = new ArrayList<>();
 
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            b.add(sc.nextInt());
        }
      
      
        int count = 0;
        for (int i = 0, j = 0; i < n && j < m; j++) {
            if (b.get(j) >= a.get(i)) {
                count++;
                i++;
            }
        }
 
        System.out.print(n - count);
    }
}
