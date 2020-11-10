/*
https://codeforces.com/problemset/problem/723/D
*/
// package whatever; // don't place package name!

import java.io.*;
import java.util.*;

/*
1. Count # of lakes => save lakes in an array
2. Sort all lakes by size
3. Get smallest lake to fill (k)
*/

class MyCode {
  static char[][] berland;
  static int n, m, k;
  static boolean[][] visited;
  static ArrayList<Cell> lake;
  static ArrayList<ArrayList<Cell>> allLakes;
  
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    m = scan.nextInt();
    k = scan.nextInt();
    berland = new char[n][m];
    for(int i = 0; i < n; i++) {
      String line = scan.next();
      for(int j = 0; j < m; j++) {
        berland[i][j] = line.charAt(j);
      }
    }
    
    visited = new boolean[n][m];
    allLakes = new ArrayList<>();
    
    for(int i = 1; i < n-1; i++) {
      for(int j = 1; j < m-1; j++) {
        Cell c = new Cell(i, j);
        if (berland[i][j] == '.' && !visited[i][j]) {
          lake = new ArrayList<>();
          boolean bool = DFS(c);
          if(bool) { // valid lake
            allLakes.add(lake);
          }
        }
      }
    }
    
    Collections.sort(allLakes, new cellCompare());
    
    int nlakes = allLakes.size();
    nlakes = nlakes - k;
    int totalNumCell = 0;
    for(int i = 0; i < nlakes; i++) {
      totalNumCell += allLakes.get(i).size();
      for(int j = 0; j < allLakes.get(i).size(); j++) {
        berland[allLakes.get(i).get(j).x][allLakes.get(i).get(j).y] = '*';
      }
    } 
    
    System.out.println(totalNumCell);
    
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        System.out.print(berland[i][j]);
      }
      System.out.println();
    }
  }  
  
  
  public static boolean DFS(Cell s) {
    lake.add(s);
    boolean answer = true;
    visited[s.x][s.y] = true;
    if (s.x == 0 || s.x == n-1 || s.y == 0 || s.y == m-1) {
      answer = false;
    }
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    for(int i = 0; i < 4; i++) {
      int ux = dx[i] + s.x;
      int uy = dy[i] + s.y;
      if(0 <= ux && ux < n && 0 <= uy && uy < m) {
        if(!visited[ux][uy] && berland[ux][uy] == '.') {
          Cell c = new Cell(ux, uy);
          answer &= DFS(c);
          }
        }
      }
      
    return answer;
  }
}


class Cell {
  int x;
  int y;
  
  public Cell(int x, int y) {
    this.x = x;
    this.y = y;
  }
}


class cellCompare implements Comparator<ArrayList<Cell>> {
  @Override
  public int compare(ArrayList<Cell> a1, ArrayList<Cell> a2) {
    if(a1.size() < a2.size()) {
      return -1;
    }
    return 1;
  }
}
