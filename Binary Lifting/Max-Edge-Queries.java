/*
https://www.interviewbit.com/problems/max-edge-queries/?fbclid=IwAR0coyM6OlEwvgKxXdZzwCKUvRJ7-O_z0g-cPqIPg0mjRap6XAxbrrA7HP0/#
*/

public class Solution {
    static int N;
    static List<List<int[]>> graph;
    static int[] tin;
    static int[] tout;
    static int[][] parents;
    static int[][] maxEdge;
    static int time;
    static int l;

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> queryAns = new ArrayList<>();
        graph = new ArrayList<>();
        N = A.size() + 1;
        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < A.size(); i++) {
            List<Integer> edge = A.get(i);
            int u = edge.get(0) - 1;
            int v = edge.get(1) - 1;
            int w = edge.get(2);
            int[] info = new int[2];
            info[0] = v;
            info[1] = w;
            graph.get(u).add(info);
            int[] info1 = new int[2];
            info1[0] = u;
            info1[1] = w;
            graph.get(v).add(info1);
        }
        preprocess();
        for(int i = 0; i < B.size(); i++) {
            List<Integer> curr = B.get(i);
            int u = curr.get(0) - 1;
            int v = curr.get(1) - 1;
            queryAns.add(LCA(u, v));
        }
        return queryAns;
    }

    private static void dfs(int u, int p) {
        time++;
        parents[u][0] = p;
        tin[u] = time;
        
        for(int[] e : graph.get(u)) {
            int neighbor = e[0];
            int weight = e[1];
            
            if(neighbor == p) {
                maxEdge[u][0] = weight;
            }
        }

        for(int[] e : graph.get(u)) {
            int neighbor = e[0];
            int weight = e[1];
            
            if(neighbor != p) {
                dfs(neighbor, u);
            }
        }
        tout[u] = time;
    }

    private static boolean isAncestor(int u, int v) {
        return tin[u] <= tin[v] && tout[u] >= tout[v];
    }

    private static int log2(int n) {
        return (int)(Math.log(n)/Math.log(2));
    }

    private static void preprocess() {
        tin = new int[N];
        tout = new int[N];
        time = 0;
        l = log2(N);
        parents = new int[N][l+1];
        maxEdge = new int[N][l+1];

        dfs(0, 0);

        for(int k = 1; k <= l; k++) {
            for(int u = 0; u < N; u++) {
                parents[u][k] = parents[parents[u][k-1]][k-1];
                maxEdge[u][k] = Math.max(maxEdge[u][k-1], maxEdge[parents[u][k-1]][k-1]);
            }
        }
    }

    private static int LCA(int u, int v) { // returns max edge weight in path(u, v)
        int currMaxEdge = -1;

        if(isAncestor(u, v)) {
            int temp = v;
            v = u;
            u = temp;    
        }

        for(int k = l; k >= 0; k--) {
            if(!isAncestor(parents[u][k], v)) { // jump in smaller step if this condition is true
                currMaxEdge = Math.max(currMaxEdge, maxEdge[u][k]);
                u = parents[u][k];
            }
        }

        int lca = parents[u][0];
        currMaxEdge = Math.max(currMaxEdge, maxEdge[u][0]);
        if(lca == v) {
            return currMaxEdge;
        } else { // path gap khuc: u -> lca -> v
            for(int k = l; k >= 0; k--) {
                if(!isAncestor(parents[v][k], lca)) {
                    currMaxEdge = Math.max(currMaxEdge, maxEdge[v][k]);
                    v = parents[v][k];
                }
            }
            // parents[v][0] is lca
            currMaxEdge = Math.max(currMaxEdge, maxEdge[v][0]);
            return currMaxEdge;
        }
    }


}
