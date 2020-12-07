/*
https://www.hackerrank.com/challenges/java-arraylist/problem
*/
import java.io.*;
import java.util.*;

public class Solution {
    static ArrayList<ArrayList<Integer>> arr;
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        arr = new ArrayList<ArrayList<Integer>>();
        int n = scan.nextInt();
        for(int i = 0; i < n; i++) {
            arr.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < n; i++) {
            int num = scan.nextInt();
            for(int j = 0; j < num; j++) {
                int x = scan.nextInt();
                arr.get(i).add(x);
            }
        }
        
        int query = scan.nextInt();
        for(int i = 0; i < query; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            ArrayList<Integer> temp = arr.get(x-1);
            if(y > temp.size()) {
                System.out.println("ERROR!");
            } else {
                System.out.println(temp.get(y-1));
            }
        }
        
        
    }
}
