/*
https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=378
*/
import java.util.*;
import java.io.*;

class Block implements Comparable<Block> {
    public int[] dimension = new int[3];

    public Block(int x, int y, int z) {
        this.dimension[0] = x;
        this.dimension[1] = y;
        this.dimension[2] = z;
    }

    @Override
    public int compareTo(Block other) {
        for (int i = 0; i < 3; i++) {
            if (this.dimension[i] != other.dimension[i]) {
                return this.dimension[i] - other.dimension[i];
            }
        }
        return 0;
    }

    public boolean canStack(Block other) { // can stack current block on other block or not
        if (this.dimension[0] < other.dimension[0] && this.dimension[1] < other.dimension[1]) {
            return true;
        } else {
            return false;
        }
    }

}

class MyCode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = 1;
        while (true) {
            int n = scan.nextInt();
            if (n == 0) {
                break;
            }
            List<Block> blocks = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                int z = scan.nextInt();
                int[] temp = new int[] { x, y, z };
                blocks = getPerm(temp, blocks, 0, 3);
            }
            Collections.sort(blocks, Collections.reverseOrder());
            int maxHeight = LIS(blocks);
            System.out.println("Case " + testCase + ": maximum height = " + maxHeight);
            testCase++;
        }
    }

    private static int LIS(List<Block> blocks) {
        int n = blocks.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = blocks.get(i).dimension[2];
        }
        int maxHeight = -1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (blocks.get(i).canStack(blocks.get(j)) && dp[j] + blocks.get(i).dimension[2] > dp[i]) {
                    dp[i] = dp[j] + blocks.get(i).dimension[2];
                    maxHeight = Math.max(maxHeight, dp[i]);
                }
            }
        }
        return maxHeight;
    }

    private static List<Block> getPerm(int[] arr, List<Block> perm, int l, int r) {
        if (l >= r) {
            int[] ans = arr.clone();
            Block b = new Block(ans[0], ans[1], ans[2]);
            perm.add(b);
        }
        for (int i = l; i < r; i++) {
            boolean check = shouldSwap(arr, l, i);
            if (check) {
                int temp = arr[i];
                arr[i] = arr[l];
                arr[l] = temp;
                getPerm(arr, perm, l + 1, r);
                int temp1 = arr[i];
                arr[i] = arr[l];
                arr[l] = temp1;
            }
        }
        return perm;
    }

    private static boolean shouldSwap(int[] arr, int l, int r) {
        for (int i = l; i < r; i++) {
            if (arr[i] == arr[r]) {
                return false;
            }
        }
        return true;
    }

}
