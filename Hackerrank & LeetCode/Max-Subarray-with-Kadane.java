// Solution using Kadane's algorithm
/*
Idea:
Loop through every element in the array - Ask the question "What is the max sum up to this point?"
Either start a new array with only such element, or include that element in the existing subarray.
*/
import java.lang.Math;

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = maxSum;
        for(int i=1; i<nums.length; i++) {
            currSum = Math.max(nums[i] + currSum, nums[i]);
            if(currSum > maxSum) {
                maxSum = currSum;
            }
        }
        return maxSum;
    }
}
