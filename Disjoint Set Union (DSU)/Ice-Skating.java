/*
https://codeforces.com/problemset/problem/217/A
Idea: 
- Group all points which are reachable from one another into a components.
- Reachable from one another = share x OR y coordinate.
- Number of drifts need to be created = components - 1.
*/
import java.util.*;
import java.io.*;

class Coordinate {
    public int x;
    public int y;
    
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class MyCode {
    public static int[] parent;
    public static int[] size;
    public static int count;
    public static int n;
    public static Coordinate[] list;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        list = new Coordinate[n];
        makeSet();
        for(int i = 0; i < n; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            list[i] = new Coordinate(a, b);
        }        
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i != j && (list[i].x == list[j].x || list[i].y == list[j].y)) {
                    union(i, j);
                }
            }
        }
        System.out.println(--count);
        
	}
    
    public static void makeSet() {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public static int find(int p) {
        int root = p;
        while (root != parent[root]) {
            root = parent[root];
        }
        while (p != root) {
            int newp = parent[p];
            parent[p] = root;
            p = newp;
        }
        return root;
    }

    public static void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }   
}
