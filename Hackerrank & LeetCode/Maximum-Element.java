/*
https://www.hackerrank.com/challenges/maximum-element/problem
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        /*
        Idea: have 1 main stack, 1 max stack. maxStack: peek() of which is the current max value in mainStack
        */
        Scanner scan = new Scanner(System.in);
        Stack<Long> mainStack = new Stack<>();
        Stack<Long> maxStack = new Stack<>();
        int n = scan.nextInt();
        long max = Long.MIN_VALUE;
        maxStack.push(max);
        for(int i = 0; i < n; i++) {
            int x = scan.nextInt();
            if(x == 1) {
                long input = scan.nextLong();
                mainStack.push(input);
                long currMax = maxStack.peek();
                if(input > currMax) {
                    maxStack.push(input);
                    currMax = input;
                } else {
                    maxStack.push(currMax);
                }
            } else if (x == 2) {
                mainStack.pop();
                maxStack.pop();
            } else {
                System.out.println(maxStack.peek());
            }
        }
        
    }
}
