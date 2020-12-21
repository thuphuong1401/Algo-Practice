/*

https://www.students.cs.ubc.ca/~cs-490/Spring06/questions/sp3.html
Ứng với mỗi test case, đầu tiên ta sẽ tìm cây khung ngắn nhất trên đồ thị dựa vào thuật toán Prim, lưu ý rằng đồ thị có thể là một rừng, tức có nhiều đồ thị đơn lẻ,
nên ta phải tìm từng cây khung ứng với từng đồ thị. Sau đó ta sẽ duyệt DFS để tìm đường đi từ c1 đến c2. Kết quả sẽ là mức âm thanh của cạnh lớn nhất khi ta đi từ 
c1 đến c2.

Độ phức tạp: O(S*log(C) + Q * (C-1)),chi phí Prim O(S*log(C)) với S là số cạnh, C là số đỉnh và chi phí duyệt DFS với M truy vấn: O(Q * (C-1)) với Q là số truy vấn, 
C là số đỉnh ban đầu.
*/

import java.util.*;
import java.io.*;


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

class Main { 
    static final int MAX = 110;
    static final int INF = (int)1e9;
    static ArrayList<Node> mstGraph[] = new ArrayList[MAX];
    static ArrayList<Node> graph[] = new ArrayList[MAX];
    static boolean visited[] = new boolean[MAX];
    static int path[] = new int[MAX];
    static int dist[] = new int[MAX];
    static int C, S, Q;
 
    public static void prim(int src) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(src, 0));
        dist[src] = 0; 
        while (!pq.isEmpty()) {
            Node top = pq.poll();
            int u = top.id;
            visited[u] = true;
            for (int i = 0; i < graph[u].size(); i++) {
                Node neighbor = graph[u].get(i);
                int v = neighbor.id, w = neighbor.dist;
                if (!visited[v] && dist[v] > w) {
                    dist[v] = w;
                    pq.add(new Node(v, w));
                    path[v] = u;
                }
            }
        }
    
        for (int u = 2; u <= C; u++) {
            if (path[u] != -1) {
                int v = path[u];
                int w = dist[u];
                mstGraph[u].add(new Node(v, w));
                mstGraph[v].add(new Node(u, w));
            }
        }
    } 
    
    static int dfs(int src, int dst, int level) {
        if (src == dst)
            return level;
        visited[src] = true;
        for (int i = 0; i < mstGraph[src].size(); i++) {
            int v = mstGraph[src].get(i).id;
            int w = mstGraph[src].get(i).dist;
            if (!visited[v]) {
                int tmpLevel = dfs(v, dst, Math.max(level, w));
                if (tmpLevel != INF)
                    return tmpLevel;
            }
        }
        return INF;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int u, v, w;
        int tc = 1;
        for(int i = 0 ; i < MAX; i++) {
            graph[i] = new ArrayList<>();
            mstGraph[i] = new ArrayList<>();
        }
        while (true) {
            C = in.nextInt();
            S = in.nextInt();
            Q = in.nextInt();
            if (C == 0 && S == 0 && Q == 0)
                break;
            
            for (int i = 1; i <= C; i++) {
                mstGraph[i].clear();
                graph[i].clear();
                visited[i] = false;
                dist[i] = INF;  
                path[i] = -1;
            }

            for (int i = 0; i < S; i++) {
                u = in.nextInt();
                v = in.nextInt();
                w = in.nextInt();
                graph[u].add(new Node(v, w));
                graph[v].add(new Node(u, w));
            }
            
            for (int i = 1; i <= C; i++)
                if (!visited[i])
                    prim(i);

            if (tc != 1)
                System.out.println();
            System.out.printf("Case #%d\n", tc++);
            for (int i = 0; i < Q; i++) {
                u = in.nextInt();
                v = in.nextInt();
                Arrays.fill(visited, false);
                int level = dfs(u, v, 0);
                if (level != INF)
                    System.out.printf("%d\n", level);
                else
                    System.out.printf("no path\n");
            }
        }
    }
}

