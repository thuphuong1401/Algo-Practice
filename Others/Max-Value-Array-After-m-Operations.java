
/*
https://www.geeksforgeeks.org/maximum-value-array-m-range-increment-operations/?fbclid=IwAR22k1IDTx7fcM129JYr73k3EdCoJWgx2DEk_L44zwsvN0tkkr_S-r1uaas
Maximum value array m range increment operations
*/

import java.io.*;
import java.util.*;

class MyCode {

    public static int findMaxValue(int n, int[][] op) {
        int[] investments = new int[n + 1];
        for (int i = 0; i < op.length; i++) {
            int left = op[i][0];
            int right = op[i][1];
            int contrib = op[i][2];

            investments[left] += contrib;
            investments[right + 1] -= contrib;

        }

        int currPrefixSum = 0;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            currPrefixSum += investments[i];
            maxSum = Math.max(currPrefixSum, maxSum);
        }

        return maxSum;

    }

    public static void main(String[] args) {
        int[][] operations = { { 0, 1, 100 }, { 1, 4, 100 }, { 2, 3, 100 } };
        int max = findMaxValue(5, operations);
        System.out.println(max);
    }
}
