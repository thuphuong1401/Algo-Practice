/*
https://www.spoj.com/problems/SAMER08A/
*/

import java.io.*;
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

class MyCode {
    public static ArrayList<ArrayList<Node>> graph;
    public static ArrayList<ArrayList<Node>> graphS;
    public static ArrayList<ArrayList<Node>> graphD;
    public static int[] dist;
    public static int[] distS;
    public static int[] distD;
    public static int n, m, s, d;
    public static int shortestLength;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            n = scan.nextInt();
            m = scan.nextInt();
            if(n==0 && m==0) {
                break;
            }
            s = scan.nextInt();
            d = scan.nextInt();
            
            graph = new ArrayList<ArrayList<Node>>();
            graphS = new ArrayList<ArrayList<Node>>();
            graphD = new ArrayList<ArrayList<Node>>();
            
            dist = new int[n];
            distS = new int[n];
            distD = new int[n];
            
            for(int i = 0; i < n; i++) {
                graph.add(new ArrayList<Node>());
                graphS.add(new ArrayList<Node>());
                graphD.add(new ArrayList<Node>());
                dist[i] = Integer.MAX_VALUE;
                distS[i] = Integer.MAX_VALUE;
                distD[i] = Integer.MAX_VALUE;
            }
            
            for(int i = 0; i < m; i++) {
                int u = scan.nextInt();
                int v = scan.nextInt();
                int d = scan.nextInt();
                graphS.get(u).add(new Node(v, d));
                // reverse!
                graphD.get(v).add(new Node(u, d));    
            }   
            
            // find shortest path length from s to all other vertices
            dijkstra(s, graphS, distS);
            // find shortest path length from all other vertices to d
            dijkstra(d, graphD, distD);
            
            shortestLength = distS[d];
            
            // create new graph containing NO edge from shortest path(s)
            for(int u = 0; u < n; u++) {
                for(int i = 0; i < graphS.get(u).size(); i++) {
                    Node temp = graphS.get(u).get(i);
                    int v = temp.id;
                    int w = temp.dist;
                    if(distS[u] + w + distD[v] != shortestLength) {
                        graph.get(u).add(new Node(v, w));
                    }
                }    
            }
            
            dijkstra(s, graph, dist);
            
            if(dist[d] != Integer.MAX_VALUE) {
                System.out.println(dist[d]);
            } else {
                System.out.println(-1);
            }
            
            // Reset for new test cases
            graph.clear();
            graphS.clear();
            graphD.clear();
            shortestLength = 0;
        }
	}
    
    public static void dijkstra(int s, ArrayList<ArrayList<Node>> graph, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dist[s] = 0;
        while(!pq.isEmpty()) {
            Node top = pq.remove();
            int u = top.id;
            int w = top.dist;
            if(w > dist[u]) {
                continue;
            }
            for(int i = 0; i < graph.get(u).size(); i++) {
                Node neighbor = graph.get(u).get(i);
                if(neighbor.dist + w < dist[neighbor.id]) {
                    dist[neighbor.id] = w + neighbor.dist;
                    pq.add(new Node(neighbor.id, dist[neighbor.id]));
                }
            }
        }
    }
}



