/*
https://vjudge.net/problem/Kattis-brexitnegotiations
*/

import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int id;
    Integer weight;
    
    public Node(int id, Integer weight) {
        this.id = id;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node other) {
        return this.weight.compareTo(other.weight);
    }
    
}

class MyCode {
    static List<List<Integer>> graph;
    static int[] weight;
    
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        graph = new ArrayList<List<Integer>>();
        
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());    
        }
        
        weight = new int[n];
        int[] inDegree = new int[n];
        
        for(int i = 0; i < n; i++) {
            int e = scan.nextInt();
            weight[i] = e;
            int d = scan.nextInt();
            for(int j = 0; j < d; j++) {
                int v  = scan.nextInt()-1;
                graph.get(i).add(v); 
                inDegree[v]++;
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                pq.add(new Node(i, weight[i]));
            }
        }
        
        int minLength = Integer.MIN_VALUE;
        int numMeetingBefore = n-1;
        
        while(!pq.isEmpty()) {
            Node top = pq.remove();
            minLength = Math.max(minLength, top.weight + numMeetingBefore);
            
            --numMeetingBefore;
            
            for(int i : graph.get(top.id)) {
                inDegree[i]--;
                if(inDegree[i] == 0) {
                    pq.add(new Node(i, weight[i]));    
                }
            }
        }
        
        System.out.println(minLength);   
    }
}


