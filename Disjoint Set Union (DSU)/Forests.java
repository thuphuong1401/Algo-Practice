/*
https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1168
*/

import java.util.*;
import java.io.*;

class MyCode {
    
    private static int[] parent;
    private static int[] size;
    private static int count;
    private static Map<Integer, List<Integer>> map;
    private static int n, t, x, y;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        scan.nextLine();
        scan.nextLine();
        while(numTestCases > 0) {
            String firstLine = scan.nextLine();
            String[] token = firstLine.split(" ");
            n = Integer.parseInt(token[0]);
            t = Integer.parseInt(token[1]);
            
            makeSet();
            
            String line;
            while(scan.hasNextLine() && !(line = scan.nextLine()).equals("")) {
                String[] tokens = line.split(" ");
                int x = Integer.parseInt(tokens[0]) - 1;
                int y = Integer.parseInt(tokens[1]);
                
                if(!map.containsKey(x)) {
                    map.put(x, new ArrayList<Integer>());
                }
                map.get(x).add(y);
            }
            
            for(int i = 0; i < n; i++) {
                for(int j = i; j < n; j++) {
                    if(sameOpinion(i, j)) {
                        union(i, j);
                    }
                }
            }
            
            
            // Person i hears no tree falling
            for(int i = 0; i < n; i++) {
                if(map.get(i) == null && count != 1) {
                    count--;
                    break;
                }
            }
            
            System.out.println(count);
            System.out.println();
            numTestCases--;
            map.clear();
        } 
        
	}
    
    public static boolean sameOpinion(int p, int q) {
        List<Integer> hearP = map.get(p);
        List<Integer> hearQ = map.get(q);
        Set<Integer> compareP = new HashSet<>();
        Set<Integer> compareQ = new HashSet<>();
        if(hearP != null && hearQ != null) {
            for(int i : hearP) {
                compareP.add(i);
            }
            for(int i : hearQ) {
                compareQ.add(i);
            }
        }
        return compareP.equals(compareQ);
    }
    
    public static void makeSet() {
        count = n;
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        map = new HashMap<>();
    }
    
    public static int find(int p) {
        int root = p;
        while(root != parent[root]) {
            root = parent[root];
        }
        while(p != root) {
            int newp = parent[p];
            parent[p] = root;
            p = newp;
        }
        return root;
    }
    
    public static void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) {
            return;
        }
        if(size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }
    
}
