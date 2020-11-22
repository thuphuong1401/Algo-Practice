/*
https://www.spoj.com/problems/TRVCOST/cstart=40
*/

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    Integer id;
    Integer dist;

    public Node(Integer id, Integer dist) {
        this.id = id;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node other) {
        return this.dist.compareTo(other.dist);
    }
}

class MyCode {
    static int[] dist;
    static int[] path;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i <= 500; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < n; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int w = scan.nextInt();
            graph.get(a).add(new Node(b, w));
            graph.get(b).add(new Node(a, w));
        }

        int u = scan.nextInt();
        dist = new int[501];
        path = new int[501];
        for (int i = 0; i <= 500; i++) {
            dist[i] = Integer.MAX_VALUE;
            path[i] = -1;
        }

        dijkstra(u);

        int q = scan.nextInt();
        for (int i = 0; i < q; i++) {
            int v = scan.nextInt();
            if (dist[v] != Integer.MAX_VALUE) {
                System.out.println(dist[v]);
            } else {
                System.out.println("NO PATH");
            }
        }
    }

    public static void dijkstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dist[s] = 0;

        while (!pq.isEmpty()) {
            Node top = pq.remove();
            int u = top.id;
            int w = top.dist;
            for (int i = 0; i < graph.get(u).size(); i++) {
                Node neighbor = graph.get(u).get(i);
                if (w + neighbor.dist < dist[neighbor.id]) {
                    dist[neighbor.id] = w + neighbor.dist;
                    path[neighbor.id] = u;
                    pq.add(new Node(neighbor.id, dist[neighbor.id]));
                }
            }
        }
    }
}
