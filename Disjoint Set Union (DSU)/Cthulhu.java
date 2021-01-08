import java.util.*;
import java.io.*;

/*
https://codeforces.com/problemset/problem/104/C
Brief: given a graph, determine whether the graph is composed of several tree roots
where all roots are connected to form a cycle
=> Check whether there's only 1 component (count == 1) and n == m
*/

class MyCode {
    static int[] parents;
    static int[] size;
    static int count;
    static int n, m;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        makeSet();
        for(int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            union(a, b);
        }
        boolean isCthulhu = false;
        if(n == m && count == 1) {
            isCthulhu = true;
        }
        if(isCthulhu) {
            System.out.println("FHTAGN!");
        } else {
            System.out.println("NO");
        }
	}
    
    
    public static void makeSet() {
        parents = new int[n+1];
        size = new int[n+1];
        for(int i = 0; i <= n; i++) {
            parents[i] = i;
            size[i] = 1;
        }
        count = n;
    }
    
    public static int find(int p) {
        int root = p;
        while(root != parents[root]) {
            root = parents[root];
        }
        while(p != root) {
            int newp = parents[p];
            parents[p] = root;
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
            parents[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }
    
}
