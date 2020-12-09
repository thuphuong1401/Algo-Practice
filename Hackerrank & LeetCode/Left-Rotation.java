/*
https://www.hackerrank.com/challenges/array-left-rotation/problem
*/
import java.util.*;

class Solution {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] leftRotated = new int[n];
        for(int i = 0; i < n; i++) {
            int x = Math.abs(i+n-k) % n;
            leftRotated[x] = scan.nextInt();
        }
        for(int i = 0; i < n; i++) {
            System.out.print(leftRotated[i] + " ");
        }
    }
}
