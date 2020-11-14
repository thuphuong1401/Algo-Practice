// package whatever; // don't place package name!

/*
https://www.spoj.com/problems/MAKEMAZE/
*/


import java.io.*;
import java.util.*;

class MyCode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        for (int i = 0; i < numTestCases; i++) {
            int row = scan.nextInt();
            int col = scan.nextInt();
            char[][] maze = new char[row][col];
            for (int j = 0; j < row; j++) {
                String line = scan.next();
                for (int k = 0; k < col; k++) {
                    maze[j][k] = line.charAt(k);
                }
            }

            // 1st condition: only 1 entrance, 1 exit
            ArrayList<Point> dots = new ArrayList<>();
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (j == 0 || k == 0 || j == row - 1 || k == col - 1) {
                        if (maze[j][k] == '.') {
                            dots.add(new Point(j, k));
                        }
                    }
                }
            }

            if (dots.size() != 2) {
                System.out.println("invalid");
                continue;
            }

            // 2 condition: there is a path from start to end point
            BFS(dots.get(0), dots.get(1), maze);

        }
    }

    public static void BFS(Point s, Point f, char[][] maze) {
        int row = maze.length;
        int col = maze[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<Point> queue = new LinkedList<Point>();

        visited[s.x][s.y] = true;
        queue.add(s);

        while(!queue.isEmpty()) {
            Point consider = queue.remove();
            int ux = consider.x;
            int uy = consider.y;
            // up, down, left, right
            int[] dx = {-1, 1, 0, 0}; // changes in row coordinates
            int[] dy = {0, 0, -1, 1}; // changes in column coordinates
            for(int i = 0; i < 4; i++) {
                int vx = ux + dx[i];
                int vy = uy + dy[i];
                if(0 <= vx && vx < row && 0 <= vy && vy < col) {
                    if(!visited[vx][vy] && maze[vx][vy] == '.') {
                        visited[vx][vy] = true;
                        queue.add(new Point(vx, vy));
                    }
                }
            }
        }
        
        if(visited[f.x][f.y] == true) {
          System.out.println("valid");
          return;
        }
        
        System.out.println("invalid");
        
        
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
