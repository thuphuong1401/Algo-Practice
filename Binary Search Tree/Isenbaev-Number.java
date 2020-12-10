
/*
https://acm.timus.ru/problem.aspx?space=1&num=1837
*/
import java.io.*;
import java.util.*;

/*
Idea:
- Moi nguoi la 1 dinh tren graph
- BFS tren graph
- TreeMap<String, Integer> => <name, vertex_id>
*/

class MyCode {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] dist;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 301; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int j = 0;
        scan.nextLine();
        while (scan.hasNext()) {

            String[] arr = scan.nextLine().split(" ");

            List<Integer> id = new ArrayList<>(); // use to build graph edges
            for (int i = 0; i < 3; i++) {
                if (!treeMap.containsKey(arr[i])) { // put <names, vertex id> into treeMap
                    treeMap.put(arr[i], j);
                    j++;
                }
                id.add(treeMap.get(arr[i]));
            }

            // each line has 3 names => 6 directed edges
            for (int i = 0; i < id.size(); i++) {
                for (int l = i + 1; l < id.size(); l++) {
                    graph.get(id.get(i)).add(id.get(l));
                    graph.get(id.get(l)).add(id.get(i));

                }
            }
        }

        // run BFS starting from <Isenbaev, 0>
        BFS(treeMap.get("Isenbaev"), j); // j: # of vertices(names)
        for (String s : treeMap.keySet()) {
            if (!visited[treeMap.get(s)]) {
                System.out.println(s + " " + "undefined");
            } else {
                System.out.println(s + " " + dist[treeMap.get(s)]);
            }
        }
    }

    public static void BFS(int s, int j) {
        Queue<Integer> q = new LinkedList<>();
        dist = new int[j];
        visited = new boolean[j];
        visited[s] = true;
        dist[s] = 0;
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.remove();
            for (int i = 0; i < graph.get(u).size(); i++) {
                int v = graph.get(u).get(i);
                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
    }
}
