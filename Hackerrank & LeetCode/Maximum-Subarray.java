import java.lang.Math;

// naive max subarray for all size k (not using Kadane)

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0; i<nums.length; i++) {
            currSum = 0;
            for(int j=i; j<nums.length; j++) {
                currSum += nums[j];
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum;
    }
}
