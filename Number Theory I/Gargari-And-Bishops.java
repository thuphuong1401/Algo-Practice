/*
https://codeforces.com/problemset/problem/463/C

This problem is very interesting.

Key insights:
1. Black squares has x + y odd, white squares has x + y even 
2. Both bishops cannot be place on same colored squares (they'll attack at least 1 square in common)
3. All squares lying on the same diagonal parallel to the main diagonal has x - y invariant
   All squares lying on the same diagonal parralel to the secondary diagonal has x + y invariant
=> Therefore we can precalculate the sum of each diagonal parralel to the main diagonal and each diagonal parralel to the secondary diagonal
4. Need to find a best score when placing a bishop on a black square and a best score when placing a bishop on a white square.
5. Score = principalDiagonal[coord] + secondaryDiagonal[coord] - points[coord.x][coord.y] (because of double counting current position's point)
*/
import java.util.*;
import java.io.*;

class MyCode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[][] board = new long[n + 1][n + 1];
        long[] principalDiagonal = new long[2 * (n + 1)];
        long[] secondaryDiaognal = new long[2 * (n + 1)];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = scan.nextLong();

                int coordPrincipal = getPrincipalDiagonal(i, j, n);
                int coordSecondary = getSecondaryDiagonal(i, j);

                principalDiagonal[coordPrincipal] += board[i][j];
                secondaryDiaognal[coordSecondary] += board[i][j];
            }
        }

        long bestWhite = 0, bestBlack = 0;
        int xW = 1, yW = 1, xB = 1, yB = 2;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                long totalPoints = principalDiagonal[getPrincipalDiagonal(i, j, n)]
                        + secondaryDiaognal[getSecondaryDiagonal(i, j)] - board[i][j];
                if (blackOrWhite(i, j).equals("WHITE")) {
                    if (totalPoints > bestWhite) {
                        bestWhite = totalPoints;
                        xW = i;
                        yW = j;
                    }
                } else {
                    if (totalPoints > bestBlack) {
                        bestBlack = totalPoints;
                        xB = i;
                        yB = j;
                    }
                }
            }
        }

        long bestScore = bestWhite + bestBlack;
        System.out.println(bestScore);
        System.out.println(xW + " " + yW + " " + xB + " " + yB);

    }

    private static int getPrincipalDiagonal(int i, int j, int n) {
        return i - j + n;
    }

    private static int getSecondaryDiagonal(int i, int j) {
        return i + j;
    }

    private static String blackOrWhite(int i, int j) {
        if ((i + j) % 2 == 0) {
            return "WHITE";
        } else {
            return "BLACK";
        }
    }
}



/*
Essentially the same but replace Scanner by BufferedReader, which is much faster. This gets AC on Codeforces while the Scanner version did not
*/
import java.util.*;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] board = new long[n + 1][n + 1];
        long[] principalDiagonal = new long[2 * (n + 1)];
        long[] secondaryDiaognal = new long[2 * (n + 1)];
        for (int i = 1; i <= n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                int coordPrincipal = getPrincipalDiagonal(i, j, n);
                int coordSecondary = getSecondaryDiagonal(i, j);

                principalDiagonal[coordPrincipal] += board[i][j];
                secondaryDiaognal[coordSecondary] += board[i][j];
            }
        }

        long bestWhite = 0, bestBlack = 0;
        int xW = 1, yW = 1, xB = 1, yB = 2;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                long totalPoints = principalDiagonal[getPrincipalDiagonal(i, j, n)]
                        + secondaryDiaognal[getSecondaryDiagonal(i, j)] - board[i][j];
                if (((i + j) & 1) == 1) {
                    if (totalPoints > bestBlack) {
                        bestBlack = totalPoints;
                        xB = i;
                        yB = j;
                    }
                } else {
                    if (totalPoints > bestWhite) {
                        bestWhite = totalPoints;
                        xW = i;
                        yW = j;
                    }
                }
            }
        }

        long bestScore = bestWhite + bestBlack;
        System.out.println(bestScore);
        System.out.println(xW + " " + yW + " " + xB + " " + yB);

    }

    private static int getPrincipalDiagonal(int i, int j, int n) {
        return i - j + n;
    }

    private static int getSecondaryDiagonal(int i, int j) {
        return i + j;
    }

}


