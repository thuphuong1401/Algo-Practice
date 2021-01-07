/*
https://www.hackerrank.com/challenges/kruskalmstrsub/problem
*/

import java.util.*;
import java.io.*;

/*
Idea:
1. Sort edges in ascending weights
2. Walk through the edges and look at the 2 nodes the edges belong to. If nodes already unified, don't include this edge
(else we create a cycle). Otherwise, include it and unify the nodes
3. The algorithm terminates when every edge has been processed or all vertices have been unified
*/

class Edge {
    int source;
    int target;
    int weight;
    
    public Edge(int source, int target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }
}

class Solution {
    static int V, E;
    static int[] parents;
    static int[] size;
    static int count;
    static List<Edge> dist;
    static List<Edge> graph;
    
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        V = scan.nextInt();
        E = scan.nextInt();
        dist = new ArrayList<>();
        graph = new ArrayList<>();
        for(int i = 0; i < E; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();
            graph.add(new Edge(u, v, w));
        }
        
        makeSet();
        Kruskal();
        printMST();
    }
    
    
    public static void Kruskal() {
        Collections.sort(graph, (o1, o2) -> (o1.weight - o2.weight));
        int i = 0;
        while(dist.size() != V-1) {
            Edge edge = graph.get(i);
            i++;
            int u = find(edge.source);
            int v = find(edge.target);
            if(u != v) {
                dist.add(edge);
                union(u, v);
            }
        }
    }
    
    
    public static void printMST() {
        int ans = 0;
        for(Edge edge : dist) {
            ans += edge.weight;
        }
        System.out.println(ans);
    }
    
    public static void makeSet() {
        parents = new int[V + 1];
        size = new int[V + 1];
        count = V;
        for(int i = 0; i < V+1; i++) {
            parents[i] = i;
            size[i] = 1;
        }
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
