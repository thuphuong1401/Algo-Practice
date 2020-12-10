/*
https://www.hackerearth.com/practice/data-structures/trees/binary-search-tree/practice-problems/algorithm/monk-and-his-friends/
*/
import java.util.*;
import java.io.*;

class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        for(int i = 0; i < numTestCases; i++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            Set<Long> treeSet = new TreeSet<>();
            for(int j = 0; j < n; j++) {
                treeSet.add(scan.nextLong());
            }
            for(int j = 0; j < m; j++) {
                long student = scan.nextLong();
                if(treeSet.contains(student)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
                treeSet.add(student);
            }
        }
	}
}




