/*
https://www.hackerrank.com/challenges/primsmstsub/problem
*/
import java.util.*;


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

class Solution {
    static int[] dist;
    static int[] path;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> graph;
    static int n, m, s;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        dist = new int[n];
        path = new int[n];
        visited = new boolean[n];
        graph = new ArrayList<ArrayList<Node>>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<Node>());
        }
        for(int i = 0; i < m; i++) {
            int u = scan.nextInt()-1;
            int v = scan.nextInt()-1;
            int w = scan.nextInt();
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }
        
        s = scan.nextInt()-1;
        prims(s);
        
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(path[i] != -1) {
                ans += dist[i];    
            }
        }
        System.out.println(ans);
    }
    
    public static void prims(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dist[s] = 0;
        while(!pq.isEmpty()) {
            Node top = pq.remove();
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
