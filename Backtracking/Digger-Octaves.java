/*
https://www.spoj.com/problems/UCI2009D/
*/
import java.util.*;
import java.io.*;

class MyCode {
        
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean[][] visited;
    public static int n;
    public static Set<Long> hashSet;
    
	  public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        while(numTestCases-- > 0) {
            n = scan.nextInt();
            char[][] matrix = new char[n][n];
            for(int i = 0; i < n; i++) {
                String line = scan.next();
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = line.charAt(j);
                }
            }
            
            visited = new boolean[n][n];
            hashSet = new HashSet<>();
            long path = 0;
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j] && matrix[i][j] == 'X') {
                        backtracking(matrix, i, j, 0, path);
                        visited[i][j] = false;
                    }
                }
            }
            
            System.out.println(hashSet.size());
            
        }
	}


    
    public static void backtracking(char[][] matrix, int i, int j, int curr, long path) {
        visited[i][j] =  true;    
        curr++;
        
        path |= (1L << i*n+j);
        
        if(curr == 8) {
            hashSet.add(path);
            return;
        }
        
        for(int l = 0; l < 4; l++) {
            int ux = i + dx[l];
            int uy = j + dy[l];
                        
            if(0 <= ux && ux < n && 0 <= uy && uy < n && !visited[ux][uy] && matrix[ux][uy] == 'X') {
                backtracking(matrix, ux, uy, curr, path);
                visited[ux][uy] = false;
            }
        }
    }
}

