/*
https://www.spoj.com/problems/RPLA/
*/

import java.util.*;
import java.io.*;

class MyCode {
    static List<List<Integer>> graph;
    static int n;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        graph = new ArrayList<List<Integer>>();
        for(int k = 1; k <= numTestCases; k++) {
            n = scan.nextInt();
            int r = scan.nextInt();
            for(int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for(int i = 0; i < r; i++) {
                int r1 = scan.nextInt();
                int r2 = scan.nextInt();
                graph.get(r2).add(r1);
            }
            
            int[] indegree = new int[n];
            int[] indegree2 = new int[n];
            for(int i = 0; i < n; i++) {
                for(int v : graph.get(i)) {
                    indegree[v]++;
                    indegree2[v]++;
                }
            }
            
            
            List<Integer> result = topoSort(indegree2);
            
            
            int[] rank = new int[n];
            
            for(int u : result) {
                if(indegree[u] == 0) {
                    rank[u] = 1;
                }
                for(int v: graph.get(u)) {
                    rank[v] = Math.max(rank[v], rank[u] + 1);
                }
            }
            
            
            ArrayList<Employee> employees = new ArrayList<>();

            for (int u = 0; u < n; u++) {
                employees.add(new Employee(u, rank[u]));
            }

            Collections.sort(employees, new Comparator<Employee>() {
                public int compare(Employee e1, Employee e2) {
                    if (e1.rank == e2.rank) {
                        return Integer.compare(e1.index, e2.index);
                    }
                    return Integer.compare(e1.rank, e2.rank);
                }
            });


            System.out.println("Scenario #" + k + ":");

            for (Employee e : employees) {
                System.out.println(e.rank + " " + e.index);
            }
            
            
            graph.clear();
        }
	}
    
    public static List<Integer> topoSort(int[] indegree) {
        // find indegree
        // add all 0 indegree into priority queue
        // poll vertex, reduce degree of all adjacent vertices => if 0 => add to priority queue!
        
            
        Queue<Integer> pq = new LinkedList<>();
    
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                pq.add(i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            int top = pq.remove();
            result.add(top);
            
            for(int u : graph.get(top)) {
                indegree[u]--;
                if(indegree[u] == 0) {
                    pq.add(u);
                }
            }
        }
        return result;
    }
}


class Employee {
    int index;
    int rank;
    
    public Employee(int index, int rank) {
        this.index = index;
        this.rank = rank;
    }
}



