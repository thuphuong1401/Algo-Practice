/*
https://codeforces.com/problemset/problem/424/B#:~:text=The%20administration%20of%20the%20Tomsk,the%20boundaries%20of%20the%20city.&text=You%20can%20widen%20the%20city%20boundaries%20to%20a%20circle%20of%20radius%20r.
*/
import java.util.*;
import java.io.*;

/*
- Calculate dist from each city to (0, 0)
- Put in treeMap(dist, population) => In treeMap, entries will be ordered by key
- Loop through all treeMap keys (now arranged from smallest to largest dist to center). If >= 1m, return. Else print -1
*/
class MyCode {
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Double, Integer> treeMap = new TreeMap<>(); // <x^2 + y^2, number of people>
        int n = scan.nextInt();
        int population = scan.nextInt();
        for(int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int k = scan.nextInt();
            double squared = Math.pow(x, 2) + Math.pow(y, 2);
            if(treeMap.containsKey(squared)) {
                treeMap.put(squared, treeMap.get(squared) + k);
            } else {
                treeMap.put(squared, k);
            }
        }
        for(Double r : treeMap.keySet()) {
            population += treeMap.get(r);
            if(population >= 1000000) {
                System.out.println(Math.sqrt(r));
                return;
            }
        }
        System.out.println(-1);
	}
}

