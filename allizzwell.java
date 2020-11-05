// package whatever; // don't place package name!

/*
https://www.spoj.com/problems/ALLIZWEL/
*/


import java.io.*;
import java.util.*;

class MyCode {
  static boolean[][] visited;
  static String allizzwell = "ALLIZZWELL";
  static char[][] matrix;
  static int r, c;
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int numTestCases = scan.nextInt();
    for(int l = 0; l < numTestCases; l++) {
      r = scan.nextInt();
      c = scan.nextInt();
      visited = new boolean[r][c];
      matrix = new char[r][c];
      for(int i = 0; i < r; i++) {
        String line = scan.next();
        for(int j = 0; j < c; j++) {
          matrix[i][j] = line.charAt(j);
        }
      }
      
      String answer = "NO";
      
      for(int i = 0; i < r; i++) {
        for(int j = 0; j < c; j++) {
          if(matrix[i][j] == 'A' && !answer.equals("YES")) {
            answer = DFS(new Point(i, j), 1);
          }
        }
      }
      
      
      System.out.println(answer);
      
      //String line = scan.next();
    }  
  }
  
  
  public static String DFS(Point s, int pos) {
  
    // clockwise
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    //visited[s.x][s.y] = true;
    
    if(pos == allizzwell.length()) {
      return "YES";
    }
    
    for(int i = 0; i < 8; i++) {
      int ux = s.x + dx[i];
      int uy = s.y + dy[i];
      if(0 <= ux && ux < r && 0 <= uy && uy < c) {
        if(!visited[ux][uy] && matrix[ux][uy] == allizzwell.charAt(pos)) {
          Point child = new Point(ux, uy);
          visited[ux][uy] = true;
          if (DFS(child, pos+1).equals("YES")) {
            return "YES";
          }
          // backtrack wrong moves
          visited[ux][uy] = false;
        }
      }
    }
    return "NO";
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
