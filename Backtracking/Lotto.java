/*
https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=382
Calculate C(n, k) for n varied, k = 6, output in lexicographical order
*/
import java.util.*;
import java.io.*;

class MyCode {
    
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            int k = scan.nextInt();
            if(k == 0) {
                break;
            }
            int[] nums = new int[k];
            for(int i = 0; i < k; i++) {
                nums[i] = scan.nextInt();
            }
            int[] res = new int[6];
            permutation(nums, res, 0, 0, 6);
            
            System.out.println();
        }
    }
    
    /*
    Big idea: Fix res[i] by assigning res[i] = nums[j], j: p -> nums.length-1
    Call permutation (i+1, j+1) to assign the next position in res and consider nums[j+1] onwards
    */
    public static void permutation(int[] nums, int[] res, int i, int p, int k) {
        if(i == k) {
            for(int l = 0; l < 6; l++) {
                System.out.print(res[l] + " "); 
            }
            System.out.println();
            return;
        } else {
            for(int j = p; j < nums.length; j++) {
                res[i] = nums[j];
                permutation(nums, res, i+1, j+1, 6);
            }   
        }   
    }  
}
