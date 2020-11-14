// brute force Leetcode solution

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length-1; i++) { // buy
            for(int j = i+1; j < prices.length; j++) { // sell
                int currProfit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, currProfit);
            }
        }
        return maxProfit;
    }
}
