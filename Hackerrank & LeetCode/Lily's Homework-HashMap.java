import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
https://www.hackerrank.com/challenges/lilys-homework/problem
Big idea:
- For O(1) time access of index given a value, use a HashMap to store (value, index)
- If arr[i] != sorted_arr[i]:
    numSwap++;
    int init = arr[i];
    swap(arr, i, map.get(sorted_arr[i]));
    // Update the indexes stored in the hash map
    map.put(init, map.get(sorted_arr[i]));
    map.put(sorted_arr[i], i);
*/
public class Solution {
    
    static Map<Integer, Integer> map;
    
    static int lilysHomework(int[] arr) {
        map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int[] copyArr = Arrays.copyOfRange(arr, 0, arr.length);
        int asc = findMinSwapAsc(arr);
        // reset
        map.clear();
        for(int i = 0; i < arr.length; i++) {
            map.put(copyArr[i], i);
        }
        //System.out.println(map);
        int desc = findMinSwapDesc(copyArr);
        int answer = Math.min(asc, desc);
        return answer;
    }
    
    static int findMinSwapAsc(int[] arr) {
        int numSwap = 0;
        int[] temp = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(temp);
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != temp[i]) {
                numSwap++;
                int init = arr[i];
                swap(arr, i, map.get(temp[i]));
                map.put(init, map.get(temp[i]));
                map.put(temp[i], i);
            }
        }
        return numSwap;
    }
    
    static int findMinSwapDesc(int[] arr) {
        int numSwap = 0;
        int[] temp = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(temp);
        reverse(temp);
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != temp[i]) {
                numSwap++;
                int init = arr[i];
                swap(arr, i, map.get(temp[i]));
                map.put(init, map.get(temp[i]));
                map.put(temp[i], i);
            }
        }
        return numSwap;
    }
    
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static void reverse(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return;
        }
        for(int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
