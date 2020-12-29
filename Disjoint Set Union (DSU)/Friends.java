import java.util.*;
import java.io.*;

/*
Find the number of elements in the largest component
https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=1549
*/


class MyCode {
    
    private static int[] parent; // parent[i] = parent of i
    private static int[] size; // size[i] = number of sites in tree rooted at i => not necessary correct if i is not a root node
    private static int count; // number of components
    private static int n, m;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        while(numTestCases > 0) {
            n = scan.nextInt();
            m = scan.nextInt();
            
            makeSet();
            for(int i = 0; i < m; i++) {
                int a = scan.nextInt() - 1;
                int b = scan.nextInt() - 1;
                union(a, b);
            }
            
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                max = Math.max(max, size[i]);
            }
            
            System.out.println(max);
            
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
        // make smaller component point to larger one
        if(size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }
}
