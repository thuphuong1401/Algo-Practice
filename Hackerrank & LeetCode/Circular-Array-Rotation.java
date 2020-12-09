/*
https://www.hackerrank.com/challenges/circular-array-rotation/problem
*/
import java.util.*;

class Solution {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int q = scan.nextInt();
        int[] rotated = new int[n];
        for(int i = 0; i < n; i++) {
            rotated[(i+k)%n] = scan.nextInt();
        }
        for(int i = 0; i < q; i++) {
            int query = scan.nextInt();
            System.out.println(rotated[query]);
        }
    }
}
