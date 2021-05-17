/*
https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=103
*/
import java.util.*;
import java.io.*;

class MyCode {
    static int[][] board;
    static int maxScore;
    static final int N = 8;
    static int[][] NQueenBoard;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            maxScore = 0;
            board = new int[8][8];
            NQueenBoard = new int[8][8];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    NQueenBoard[i][j] = scan.nextInt();
                }
            }
            solve();
        }
    }

    private static void solve() {
        NQueens(0, 0);
        String ans = Integer.toString(maxScore);
        int l = ans.length();
        int diff = 5 - l;
        for (int i = 0; i < diff; i++) {
            ans = " " + ans;
        }
        System.out.println(ans);
    }

    private static boolean check(int row, int col) {
        // check vertical
        for (int i = 0; i < row; i++) {
            if (board[i][col] != 0) {
                return false;
            }
        }

        // check main diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] != 0) {
                return false;
            }
        }

        // check secondary diagonal
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void NQueens(int row, int currScore) {
        if (row == N) {
            maxScore = Math.max(maxScore, currScore);
            return;
        }

        for (int j = 0; j < N; j++) {
            if (check(row, j)) {
                board[row][j] = 1;
                currScore += NQueenBoard[row][j];
                NQueens(row + 1, currScore);
                board[row][j] = 0;
                currScore -= NQueenBoard[row][j];
            }
        }

    }

}
