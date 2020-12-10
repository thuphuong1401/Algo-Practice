/*
https://www.hackerearth.com/practice/data-structures/trees/binary-search-tree/practice-problems/algorithm/distinct-count/
*/
import java.io.*;
import java.util.*;

class MyCode {
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        for(int i = 0; i < numTestCases; i++) {
            int n = scan.nextInt();
            int x = scan.nextInt();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for(int j = 0; j < n; j++) {
                treeSet.add(scan.nextInt());
            }
            if(treeSet.size() == x) {
                System.out.println("Good");
            } else if(treeSet.size() < x) {
                System.out.println("Bad");
            } else {
                System.out.println("Average");
            }
        }
	}
}


