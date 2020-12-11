/*
https://www.hackerrank.com/challenges/permutation-equation/problem
*/
import java.util.*;

class Solution {
    
    public static List<Integer> solve(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            hashMap.put(arr[i], i+1);
        }
        for(int i = 1; i <= max; i++) {
            int temp = hashMap.get(i);
            int temp2 = hashMap.get(temp);
            answer.add(temp2);
        }
        return answer;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        
        List<Integer> result = solve(arr);
        for(int k : result) {
            System.out.println(k);
        }
    }
    
}
