/*
https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=545
*/
import java.util.*;
import java.io.*;

class MyCode {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static Set<Character> vowels;
    static boolean[][] visited;
    static TreeSet<String> tempSet;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            char[][] board1 = new char[4][4];
            char[][] board2 = new char[4][4];
            
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 8; j++) {
                    char ch = scan.next().charAt(0);
                    if(ch == '#') {
                        return;
                    }
                    if(j < 4) {
                        board1[i][j] = ch;
                    } else {
                        board2[i][j-4] = ch;
                    }
                }
            }
            
            vowels = new HashSet<>();
            vowels.add('A');
            vowels.add('I');
            vowels.add('U');
            vowels.add('E');
            vowels.add('O');
            vowels.add('Y');
   
            tempSet = new TreeSet<>();
                     
            TreeSet<String> word1 = findWords(board1);
            TreeSet<String> word2 = findWords(board2);
            TreeSet<String> common = new TreeSet<>();
            
            
            for(String s : word1) {
                if(word2.contains(s)) {
                    common.add(s);
                }    
            }
            
            if(common.size() == 0) {
                System.out.println("There are no common words for this pair of boggle boards.");
            } else {
                for(String s : common) {
                    System.out.println(s);
                }
            }
            
            System.out.println();
        }
	}
    
    
    public static TreeSet<String> findWords(char[][] board) {
        TreeSet<String> ans = new TreeSet<>();
        visited = new boolean[4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                StringBuilder sb = new StringBuilder();
                dfs(board, i, j, sb);
                visited[i][j] = false;
                for(String s : tempSet) {
                    ans.add(s);
                }
            }
        }
        tempSet.clear();
        return ans;
    }
    
    
    public static void dfs(char[][] board, int x, int y, StringBuilder sb) {
        visited[x][y] = true;
        sb.append(board[x][y]);
        
        if(sb.length() <= 4) {
            if(sb.length() == 4 && numVowels(sb) == 2) {
                tempSet.add(sb.toString());
                return;
            }
            
            for(int i = 0; i < 8; i++) {
                int ux = x + dx[i];
                int uy = y + dy[i];
                if(0 <= ux && ux < 4 && 0 <= uy && uy < 4 && !visited[ux][uy]) {
                    dfs(board, ux, uy, sb);
                    visited[ux][uy] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
    
    
    public static int numVowels(StringBuilder sb) {
        int num = 0;
        for(int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if(vowels.contains(ch)) {
                num++;
            }
        }
        return num;
    }
    
}



