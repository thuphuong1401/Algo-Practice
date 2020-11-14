
// Using 2 pointers technique
// Leet Code problem #167, running time 0ms

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] indexToReturn = new int[2];
        int start = 0;
        int end = numbers.length - 1;
        int total = 0;
        while(start < end) {
            total = numbers[start] + numbers[end];
            if(total > target) { // Move end pointer to the right to reduce the total
                end--;
            } else if(total < target) { // Move start pointer to the left to increase the total
                start++;
            } else {
                indexToReturn[0] = start+1;
                indexToReturn[1] = end+1;
                break;
            }
        }

        return indexToReturn; 
    }
}
