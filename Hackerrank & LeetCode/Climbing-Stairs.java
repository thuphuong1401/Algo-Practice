/*
https://leetcode.com/problems/climbing-stairs/
*/

class Solution {
    
    public int climbStairs(int n) {
        int[] store = new int[n+1];
        int x = climb_stairs(n, store);
        return x;
    }
    
    public int climb_stairs(int n, int[] store) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        if(store[n] != 0) {
            return store[n];
        }
        store[0] = 1; 
        for(int i = 1; i < n+1; i++) {
            store[n] = climb_stairs(n-1, store) + climb_stairs(n-2, store);   
        }
        return store[n];
    }  
}
