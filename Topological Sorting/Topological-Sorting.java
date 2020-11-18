/*
https://www.spoj.com/problems/TOPOSORT/
*/

// package whatever; // don't place package name!

import java.io.*;
import java.util.*;

class MyCode {
    static ArrayList<ArrayList<Integer>> graph;

    public static boolean topologicalSort(ArrayList<Integer> result) {
        int V = graph.size();
        int[] indegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int v : graph.get(u)) {
                indegree[v]++;
            }
        }
        PriorityQueue<Integer> zeroIndegree = new PriorityQueue<>(); // min heap
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                zeroIndegree.add(i);
            }
        }
        while (!zeroIndegree.isEmpty()) {
            int u = zeroIndegree.poll();
            for (int v : graph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    zeroIndegree.add(v);
                }
            }
            result.add(u);
        }
        for (int x : indegree) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            graph.get(x).add(y);
        }
        ArrayList<Integer> result = new ArrayList<>(n + 1);
        boolean output = topologicalSort(result);
        if (output) {
            for (int i = 1; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
        } else {
            System.out.println("Sandro fails.");
        }
    }
}
