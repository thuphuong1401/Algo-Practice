/*
https://leetcode.com/problems/jump-game/
*/

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return true;
        }
        if(nums[0] == 0) {
            return false;
        }
        boolean[] reachable = new boolean[n];
        reachable[0] = true;
        for(int i = 0; i < n-1; i++) {
            if(reachable[i]) {
                int curr = nums[i];
                for(int j = 0; j <= curr; j++) {
                    if(i + j < n) {
                        reachable[i + j] = true;
                    } 
                }
            } else {
                break;
            }
        }
        return reachable[n-1];
    }
}
