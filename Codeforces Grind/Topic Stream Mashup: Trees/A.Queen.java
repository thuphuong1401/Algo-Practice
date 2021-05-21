/*
https://codeforces.com/gym/304970/problem/A
*/
import java.util.*;
import java.io.*;

/*
This is a very neat problem
We only need to check nodes that are:
1. Have value 1 (so that they disrespect their ancestors)
2. All of its children has value 1
*/
public class Main {

    static List<List<Integer>> adj;
    static int[] respect;
    static int n;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        adj = new ArrayList<>();
        respect = new int[n + 1];
        for (int u = 0; u <= n; u++) {
            adj.add(new ArrayList<>());
        }
        for (int u = 1; u <= n; u++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            if (x == -1) {
                continue;
            }
            adj.get(x).add(u);
            respect[u] = y;
        }
        dfs();
    }

    private static void dfs() {
        List<Integer> res = new ArrayList<>();
        for (int u = 1; u <= n; u++) {
            if (respect[u] == 1) {
                boolean remove = true;
                if (respect[u] == 1) {
                    for (int v : adj.get(u)) {
                        if (respect[v] == 0) {
                            remove = false;
                            break;
                        }
                    }
                }
                if (remove) {
                    res.add(u);
                }
            }
        }
        if (res.size() == 0) {
            System.out.println(-1);
        } else {
            for (int u : res) {
                System.out.print(u + " ");
            }
        }
    }

}
