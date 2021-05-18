
/*
https://www.hackerearth.com/practice/algorithms/graphs/topological-sort/practice-problems/algorithm/oliver-and-the-game-3/
*/
import java.util.*;
import java.io.*;

class MyCode {

    static int N;
    static int Q;
    static List<List<Integer>> graph;
    static int[] startTime;
    static int[] endTime;
    static int t;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        startTime = new int[N + 1];
        endTime = new int[N + 1]; // visited all its children
        visited = new boolean[N + 1];
        t = 0;
        dfs(1);
        Q = scan.nextInt();
        while (Q-- > 0) {
            int type = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();
            if (type == 0) {
                if (startTime[x] <= startTime[y] && endTime[x] >= endTime[y]) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                if (startTime[x] >= startTime[y] && endTime[x] <= endTime[y]) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

    }

    private static void dfs(int s) {
        t++;
        visited[s] = true;
        startTime[s] = t;
        for (int neighbor : graph.get(s)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
        endTime[s] = t;
    }

}
