/*
https://codeforces.com/problemset/problem/770/C
*/

import java.util.*;
import java.io.*;

class MyCode {
    
    static int n, k;
    static List<List<Integer>> graph;
    static List<Integer> res;
    static int[] visited;
    
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();
        List<Integer> mainCourse = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            mainCourse.add(scan.nextInt() - 1);
        }
        graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < n; i++) {
            int num = scan.nextInt();
            for(int j = 0; j < num; j++) {
                int x = scan.nextInt() - 1;
                graph.get(i).add(x);
            }
        }
        
        res = new ArrayList<>();
        visited = new int[n];
        
        for(int i = 0; i < k; i++) {
            boolean x = false;
            if(visited[mainCourse.get(i)] == 0) {
                x = dfs(mainCourse.get(i));
            }
            if(!x) {
                continue;      
            } else {
                System.out.println(-1);
                return;
            }
        }
        
        System.out.println(res.size());
        for(int i : res) {
            System.out.print(i+1 + " ");
        }
        
	}
    
   
    public static boolean dfs(int s) {
        visited[s] = 1;
        for(int i = 0; i < graph.get(s).size(); i++) {
            int neighbor = graph.get(s).get(i);
            if(visited[neighbor] == 0) {
                if(dfs(neighbor)) {
                    return true;
                }
            } else if(visited[neighbor] == 1) {
                return true;
            }
        }
        visited[s] = 2;
        res.add(s);
        return false;
    }
    
}



