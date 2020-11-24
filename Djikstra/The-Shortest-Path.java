/*
https://www.spoj.com/problems/SHPATH/
*/

import java.util.*;
import java.io.*;

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
    static ArrayList<ArrayList<Node>> graph;
    static Map<String, Integer> city;
    static int[] dist;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        for (int i = 0; i < numTestCases; i++) {
            graph = new ArrayList<ArrayList<Node>>();
            city = new HashMap<>();
            int numCities = scan.nextInt();

            for (int j = 0; j < numCities; j++) {
                graph.add(new ArrayList<Node>());
            }

            for (int j = 0; j < numCities; j++) {
                String cityName = scan.next();
                city.put(cityName, j);
                int numNeighbors = scan.nextInt();
                for (int k = 0; k < numNeighbors; k++) {
                    int b = scan.nextInt();
                    int d = scan.nextInt();
                    graph.get(j).add(new Node(b - 1, d));
                }
            }

            int numQuery = scan.nextInt();
            for (int l = 0; l < numQuery; l++) {
                String c1 = scan.next();
                String c2 = scan.next();
                int indexOfc1 = city.get(c1);
                int indexOfc2 = city.get(c2);
                dist = new int[graph.size()];
                for(int m = 0; m < dist.length; m++) {
                    dist[m] = Integer.MAX_VALUE;
                }
                dijkstra(indexOfc1);
                System.out.println(dist[indexOfc2]);
            }

            // Reset for the next test case
            graph.clear();
            city.clear();
        }
        scan.close();
    }

    public static void dijkstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dist[s] = 0;
        while (!pq.isEmpty()) {
            Node top = pq.remove();
            int u = top.id;
            int w = top.dist;
            if(dist[u] != w) {
                continue;
            }
            for (int i = 0; i < graph.get(u).size(); i++) {
                Node neighbor = graph.get(u).get(i);
                if (w + neighbor.dist < dist[neighbor.id]) {
                    dist[neighbor.id] = w + neighbor.dist;
                    pq.add(new Node(neighbor.id, dist[neighbor.id]));
                }
            }
        }
    }
}
