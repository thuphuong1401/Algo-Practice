/*
https://vjudge.net/problem/LightOJ-1041
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

class Main {
    static int[] dist;
    static int[] path;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> graph;
    static TreeMap<String, Integer> treeMap;
    static final int INF = (int) 1e9;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int l = 0; l < t; l++) { 
            treeMap = new TreeMap<String, Integer>();
            graph = new ArrayList<ArrayList<Node>>();
            int m = scan.nextInt();
            int j = 0;
            for(int i = 0; i < m; i++) {
                String s1 = scan.next();
                String s2 = scan.next();
                int d = scan.nextInt();
                if(!treeMap.containsKey(s1)) {
                    treeMap.put(s1, j++);
                    graph.add(new ArrayList<Node>());
                }
                if(!treeMap.containsKey(s2)) {
                    treeMap.put(s2, j++);
                    graph.add(new ArrayList<Node>());
                }
                int u = treeMap.get(s1);
                int v = treeMap.get(s2);
                graph.get(u).add(new Node(v, d));
                graph.get(v).add(new Node(u, d));
            }
            
            prims(0);
            
            
            long ans = 0;
            for(int k : dist) {
                ans += k;
            }
            if(ans >= INF) {
                System.out.println("Case " + (l+1) + ": Impossible");
            } else {
                System.out.println("Case " + (l+1) + ": " + ans);
            }
        }
    }
    
    public static void prims(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int n = graph.size();
        dist = new int[n];
        path = new int[n];
        visited = new boolean[n];
        Arrays.fill(dist, INF);
        Arrays.fill(path, -1);
        pq.add(new Node(s, 0));
        dist[s] = 0;
        while(!pq.isEmpty()) {
            Node top = pq.poll();
            int u = top.id;
            int w = top.dist;
            visited[u] = true;
            for(int i = 0; i < graph.get(u).size(); i++) {
                Node neighbor = graph.get(u).get(i);
                if(!visited[neighbor.id] && neighbor.dist < dist[neighbor.id]) {
                    dist[neighbor.id] = neighbor.dist;
                    pq.add(new Node(neighbor.id, neighbor.dist));
                    path[neighbor.id] = u;
                }
            }
        }
    }
    
}
