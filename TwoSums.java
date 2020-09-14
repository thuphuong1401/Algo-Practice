
// naive solution not using 2 pointers - #167, Two Sums II (sorted), LeetCode easy

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] indexToReturn = new int[2];
        for(int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            for(int j = i; j < numbers.length; j++) {
                if(diff == numbers[j]) {
                    indexToReturn[0] = i+1;
                    indexToReturn[1] = j+1;
                }
            }
            if(indexToReturn[0] != 0 && indexToReturn[1] != 0) {
                break;
            }
        }
        return indexToReturn; 
    }
}
