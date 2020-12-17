/*
https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1338
Idea:
- Calculuate pairwise Euclidean distance between all buildings
- Between buildings already had connection => dist = 0
- Run prim on such a fully connected graph
*/

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    public Integer id;
    public Integer dist;
    
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
    static int dist[];
    static int path[];
    static boolean visited[];
    static ArrayList<ArrayList<Node>> graph;
    static int n, m;
    static final int MAX = 751;
    static final int INF = (int) 1e9;
    static int x[];
    static int y[];
    static boolean edges[][];
    
    public static int distance(int i, int j) {
        int distance = (x[i] - x[j])*(x[i] - x[j]) + (y[i] - y[j])*(y[i] - y[j]);
        return distance;
    }
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {            
            n = scan.nextInt();
            x = new int[MAX];
            y = new int[MAX];
            for(int i = 0; i < n; i++) {
                x[i] = scan.nextInt();
                y[i] = scan.nextInt();    
            }
            dist = new int[n];
            path = new int[n];
            visited = new boolean[n];
            graph = new ArrayList<ArrayList<Node>>();
            for(int i = 0; i < n; i++) {
                graph.add(new ArrayList<Node>());
            }
            Arrays.fill(dist, INF);
            Arrays.fill(path, -1);
            
            m = scan.nextInt();
            edges = new boolean[n][n];
            for(int i = 0; i < m; i++) {
                int a = scan.nextInt();
                int b = scan.nextInt();
                edges[a-1][b-1] = true;
                edges[b-1][a-1] = true;
            }
            
            for(int i = 0; i < n-1; i++) {
                for(int j = i+1; j < n; j++) {
                    if(edges[i][j] == false) {
                        int d = distance(i, j);
                        graph.get(i).add(new Node(j, d));
                        graph.get(j).add(new Node(i, d));
                    } else {
                        graph.get(i).add(new Node(j, 0));
                        graph.get(j).add(new Node(i, 0));
                    }
                }
            }
            
            prims(0);
            double ans = 0;
            for(int i = 0; i < n; i++) {
                ans += Math.sqrt(dist[i]);
                if(ans >= INF) {
                    ans = -1;
                }
            }
            System.out.printf("%.2f%n", ans);
        }
    }


    public static void prims(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[s] = 0;    
        pq.add(new Node(s, 0));
        while(!pq.isEmpty()) {
            Node top = pq.remove();
            int u = top.id;
            int w = top.dist;
            visited[u] = true;
            for(int i = 0; i < graph.get(u).size(); i++) {
                Node neighbor = graph.get(u).get(i);
                if(!visited[neighbor.id] && neighbor.dist < dist[neighbor.id]) {
                    dist[neighbor.id] = neighbor.dist;
                    path[neighbor.id] = u;
                    pq.add(new Node(neighbor.id, dist[neighbor.id]));
                }
            }
        }
    }
    
    
}
