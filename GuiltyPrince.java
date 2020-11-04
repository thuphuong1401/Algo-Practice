// package whatever; // don't place package name!

/*
https://vjudge.net/problem/LightOJ-1012
*/

import java.io.*;
import java.util.*;

class MyCode {
  
  static int numCells = 1;
  static int H;
  static int W;
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int numTestCases = scan.nextInt();
    for(int m = 0; m < numTestCases; m++) {
      W = scan.nextInt();
      H = scan.nextInt();
      Point start = null;
      char[][] place = new char[H][W];
      for(int i = 0; i < H; i++) {
        String line = scan.next();
        for(int j = 0; j < W; j++) {
          char n = line.charAt(j);
          place[i][j] = n;
          if(n == '@') {
            start = new Point(i, j);
          }
        }
      }
      int result = BFS(start, place);
      System.out.printf("Case %d: %d", m+1, result);
      System.out.println();
    }
  }
  
  public static int BFS(Point s, char[][] place) {
    int numCells = 1;
    
    Queue<Point> queue = new LinkedList<>();
    boolean[][] visited = new boolean[H][W];
    queue.add(s);
    visited[s.x][s.y] = true;
    
    while(!queue.isEmpty()) {
      Point u = queue.remove();
      int ux = u.x;
      int uy = u.y;
      int[] dx = {-1, 1, 0, 0}; // up, down, left, right
      int[] dy = {0, 0, -1, 1};
      for(int i = 0; i < 4; i++) {
        int vx = ux + dx[i];
        int vy = uy + dy[i];
        if(0 <= vx && vx < H && 0<= vy && vy < W) {
          if(!visited[vx][vy] && place[vx][vy] == '.') {
            visited[vx][vy] = true;
            queue.add(new Point(vx, vy));
            numCells++;
          }
        }
      }
    }
    return numCells;  
  }
  
}

class Point {
  int x;
  int y;
  
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

