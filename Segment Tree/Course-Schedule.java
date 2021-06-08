/*
Similar to the Course Schedule problem on LeetCode. Use Kahn's algorithm to solve this problem.
*/
import java.io.*;
import java.util.*;

class MyCode {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int M = scan.nextInt();

    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      int u = scan.nextInt();
      int v = scan.nextInt();
      graph.get(u).add(v);
    }

    int[] inDegree = new int[N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < graph.get(i).size(); j++) {
        int curr = graph.get(i).get(j);
        inDegree[curr]++;
      }
    }

    Queue<Integer> zeroIndegree = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      if (inDegree[i] == 0) {
        zeroIndegree.add(i);
      }
    }

    while (!zeroIndegree.isEmpty()) {
      int u = zeroIndegree.remove();
      for (int v : graph.get(u)) {
        inDegree[v]--;
        if (inDegree[v] == 0) {
          zeroIndegree.add(v);
        }
      }
    }

    for (int v = 0; v < N; v++) {
      if (inDegree[v] != 0) {
        System.out.println("no");
        return;
      }
    }

    System.out.println("yes");
  }
}
