/*
https://www.spoj.com/problems/MKJUMPS/cstart=10
*/

import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class MyCode {
    static int[][] board; // 0 - thut vao, 1 - visited = false, 2 - visited = true
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int n;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int caseNumber = 1; 
        while(true) {
            n = scan.nextInt();
            if(n == 0) {
                return;
            }
            board = new int[n][10];
            int total = 0;
            for(int i = 0; i < n; i++) {
                int a = scan.nextInt();
                int b = scan.nextInt();
                for(int j = a; j < a + b; j++) {
                    board[i][j] = 1;
                    total++;
                }
            }
            int first = -1;
            for(int i = 0; i < 10; i++) {
                if(board[0][i] == 1) {
                    first = i;
                    break;
                }
            }
            int visited = backtrack(new Point(0, first));
            
            int ans = total - visited;
            if(ans == 1) {
                System.out.println("Case " + caseNumber + ", " + ans + " square can not be reached.");    
            } else {
                System.out.println("Case " + caseNumber + ", " + ans + " squares can not be reached.");
            }
            caseNumber++;                        
        }
	}
    
    
    private static int backtrack(Point p) {
        board[p.x][p.y] = 2;
        int count = 0;
        for(int i = 0; i < 8; i++) {
            int ux = p.x + dx[i]; 
            int uy = p.y + dy[i];
            Point move = new Point(ux, uy);
            if(0 <= ux && ux < n && 0 <= uy && uy < 10 && board[ux][uy] == 1) {
                count = Math.max(count, backtrack(move));
                board[ux][uy] = 1;
            }
        }
        return count + 1;
    }
    
}

