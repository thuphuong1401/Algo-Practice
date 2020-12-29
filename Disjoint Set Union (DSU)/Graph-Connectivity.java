/*
Write a program to determine the number of maximal connected sub-graphs of a given graph.
https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=6&page=show_problem&problem=400
*/

import java.util.*;
import java.io.*;

class MyCode {
    
    private static int[] parent;
    private static int[] size;
    private static int count;
    private static int n;
    
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        scan.nextLine();
        scan.nextLine();
        while(numTestCases > 0) {
            char max = scan.nextLine().charAt(0);
            n = max - 'A' + 1;
            makeSet();
            String line;
            while(scan.hasNextLine() && !(line = scan.nextLine()).equals("")) {
                int x = line.charAt(0) - 'A';
                int y = line.charAt(1) - 'A';
                union(x, y);   
            }
            System.out.println(count);
            System.out.println();
            
            numTestCases--;
        }
	}
    
    
    public static void makeSet() {
        count = n;
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    
    public static int find(int p) {
        int root = p;
        while(root != parent[root]) {
            root = parent[root];
        }
        while(p != root) {
            int newp = parent[p];
            parent[p] = root;
            p = newp;
        }
        return root;
    }
    
    
    public static void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) {
            return;
        }
        if(size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }
    
    
}

