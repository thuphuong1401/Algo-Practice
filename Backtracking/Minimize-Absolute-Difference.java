/*
Minimize Absolute Difference
You are given a int[] x that contains exactly five positive integers. You want to put four of them instead of the question marks into the following expression: | (?/?) - (?/?) |∣(?/?)−(?/?)∣. Which numbers should you put there and in what order, if your goal is to make the value of the expression as small as possible?

More formally, you have the following expression: ||x_a / x_b - x_c / x_d||. Here, / denotes real division (e.g., 7/2 = 3.57/2=3.5) and || denotes absolute value. You want to find the four distinct subscripts a, b, c, da,b,c,d for which the value of the expression is minimized.

Output a int[] with four elements: the optimal subscripts {a,b,c,d}. If there are multiple optimal answers, return the lexicographically smallest one among them.

Notes

Given two distinct arrays AA and BB with the same number of elements, we say that AA is lexicographically smaller than BB if AA has a smaller value at the first index at which they differ.
Dữ liệu nhập
Input contains five integers, each separated by space. Each integer will be between 11 and 1000010000, inclusive.

Dữ liệu xuất
Output four integers, separated by space, that is the optimal answer.

Example test cases:
2 3 5 7 11 => 0 3 1 4
1 1 1 1 1 => 0 1 2 3
8 2 4 2 6 => 1 0 3 4
10000 4 10 4 10 => 1 2 3 4

*/
import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

class MyCode {
    static int[] finalRes = new int[4];
    static long[] min = {10000000, 1};
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[5];
        for(int i = 0; i < 5; i++) {
            arr[i] = scan.nextInt();
        }   
        boolean[] visited = new boolean[5];
        int[] temp = new int[4];
        backtracking(arr, visited, temp, 0);  
        for(int i : finalRes) {
            System.out.print(i + " ");
        }   
    }
    
    private static void backtracking(int[] arr, boolean[] visited, int[] temp, int j) {
        for(int i = 0; i < 5; i++) {
            if(!visited[i]) {
                temp[j] = i;
                visited[i] = true;
                if(j == 3) {
                    check(arr, temp);
                } else {
                    backtracking(arr, visited, temp, j+1);
                }
                visited[i] = false;
            }
        }
    }
    
    
    public static boolean compareTwoFunctions(long num1, long denom1, long num2, long denom2) {
        return (num1 * denom2 < num2 * denom1);
    }
    
    public static void check(int[] arr, int[] temp) {
        long num = Math.abs(arr[temp[0]] * arr[temp[3]] - arr[temp[1]] * arr[temp[2]]);
        long denom = arr[temp[1]] * arr[temp[3]];
        if(compareTwoFunctions(num, denom, min[0], min[1])) {
            min[0] = num;
            min[1] = denom;
            for(int i = 0; i < 4; i++) {
                finalRes[i] = temp[i];
            }
        }
    }
    
}


