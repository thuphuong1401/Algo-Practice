/**
https://leetcode.com/problems/find-in-mountain-array/

 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
/*
Notes on ternary search:
- Ham f khong co vung dong bang

*/
class Solution {
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int top = ternarySearch(target, mountainArr);
        int index1 = bsIncreasing(top, target, mountainArr);
        if(index1 != -1) {
            return index1;
        }
        int index2 = bsDecreasing(top, target, mountainArr);
        return index2;
    }
    
    private int bsIncreasing(int top, int target, MountainArray mountainArr) {
        int l = 0; 
        int r = top;
        while(l <= r) {
            int mid = l + (r - l)/2;
            int valueMid = mountainArr.get(mid);
            if(valueMid == target) {
                return mid;
            } else if(valueMid > target) {
                r = mid-1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
    
    private int bsDecreasing(int top, int target, MountainArray mountainArr) {
        int l = top; 
        int r = mountainArr.length() - 1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            int valueMid = mountainArr.get(mid);
            if(valueMid == target) {
                return mid;
            } else if(valueMid < target) {
                r = mid-1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
    
    
    private int ternarySearch(int target, MountainArray mountainArr) {
        int l = 0;
        int r = mountainArr.length() - 1;
        
        while(r - l >= 3) {
            int m1 = l + (r - l)/3;
            int m2 = r - (r - l)/3;
            
            int valM1 = mountainArr.get(m1);
            int valM2 = mountainArr.get(m2);
            
            
            if(valM1 <= valM2) {
                l = m1;
            } 
            
            if(valM1 >= valM2) {
                r = m2;
            }
        }
        
        int peak = -1;
        int peakIndex = -1;
        for(int i = l; i <= r; i++) {
            int curr = mountainArr.get(i);
            if(curr > peak) {
                peak = curr;
                peakIndex = i;
            }
        }
        
        return peakIndex;
    }
    
}
