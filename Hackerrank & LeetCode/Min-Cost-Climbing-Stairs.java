/*
https://leetcode.com/problems/min-cost-climbing-stairs/
*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        int x = minCost(cost, dp);    
        return x;
    }
    
    public static int minCost(int[] cost, int[] dp) {
        
        if(cost.length == 0) {
            return 0;
        }
        if(cost.length == 1) {
            return cost[0];
        }
        if(cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        
        for(int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1]);
        }    
        
        return dp[cost.length];
    
    }
}
