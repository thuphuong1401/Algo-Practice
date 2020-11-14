/*
https://leetcode.com/problems/house-robber/submissions/
*/


class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] values = new int[nums.length];
        values[0] = nums[0];
        values[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            // either (1) not rob or (2) rob this house
            // (1) if not rob, values stays the same
            // (2) if rob, values[i] = values[i-2] + nums[i]
            values[i] = Math.max(values[i-1], values[i-2] + nums[i]);
        }
    return values[nums.length - 1];
    }
}
