/*
https://onlinejudge.org/external/101/10171.pdf
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
    static final int INF = (int)1e9;
    
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        
        while(true) {
            int n = scan.nextInt();
            if(n == 0) {
                break;
            }
            
            List<List<Node>> graphS = new ArrayList<List<Node>>();
            List<List<Node>> graphD = new ArrayList<List<Node>>();
            for(int i = 0; i < 26; i++) {
                graphS.add(new ArrayList<Node>());
                graphD.add(new ArrayList<Node>());
            }
            int[] distS = new int[26];
            int[] distD = new int[26];
            
            for(int i = 0; i < n; i++) {
                String age = scan.next();
                String direction = scan.next();
                String temp1 = scan.next();
                String temp2 = scan.next();
                int src = temp1.charAt(0) - 'A';
                int dist = temp2.charAt(0) - 'A';
                int weight = scan.nextInt();
                
                if(age.equals("Y")) {
                    if(direction.equals("U")) {
                        graphS.get(src).add(new Node(dist, weight));    
                    } else {
                        graphS.get(src).add(new Node(dist, weight));
                        graphS.get(dist).add(new Node(src, weight));
                    }
                } else {
                    if(direction.equals("U")) {
                        graphD.get(src).add(new Node(dist, weight));
                    } else {
                        graphD.get(dist).add(new Node(src, weight));
                        graphD.get(src).add(new Node(dist, weight));
                    }
                }
            }
            
            int start = scan.next().charAt(0) - 'A';
            int end = scan.next().charAt(0) - 'A';
            
            distS = dijkstra(start, graphS, distS);
            distD = dijkstra(end, graphD, distD);
            
            int meet = -1;
            int minDist = INF - 1;
            
            List<Integer> answer = new ArrayList<>();
            
            for(int i = 0; i < 26; i++) {
                int total = distD[i] + distS[i];
                if (total < minDist) {
                    answer.clear();
                }
                if(total <= minDist) {
                    minDist = total;
                    meet = i;      
                    answer.add(meet);  
                }
            }
            
            
            if(meet != -1) {
                System.out.print(minDist);
                for(int i = 0; i < answer.size(); i++) {
                    char m = (char)(answer.get(i) + 65);
                    System.out.print(" " + m);
                }
                System.out.println();
            }  else {
                System.out.println("You will never meet.");
            }
        }
	}
    
    
    public static int[] dijkstra(int s, List<List<Node>> graph, int[] dist) {
        Arrays.fill(dist, INF);    
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dist[s] = 0;
        while(!pq.isEmpty()) {
            Node top = pq.remove();
            int u = top.id;
            int v = top.dist;
            for(int i = 0; i < graph.get(u).size(); i++) {
                Node neighbor = graph.get(u).get(i);
                if(dist[neighbor.id] > dist[u] + neighbor.dist) {
                    dist[neighbor.id] = dist[u] + neighbor.dist;
                    pq.add(new Node(neighbor.id, dist[neighbor.id]));
                }
            }
        }
        return dist;
    }
    
    
}




