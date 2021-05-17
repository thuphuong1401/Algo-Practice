/*
Index compression.
Compress an array with big range (for eg, (-1e9,1e9), to (1,n))
Used for Fenwick Tree
*/
import java.util.*;
import java.io.*;

class MyCode {

    public static void main(String[] args) {
        int[] arr = { 9, 5, 4, 10, 4, 11, 120, 459, 9, 3 };
        Arrays.sort(arr);
        compressArr(arr);
    }

    private static void compressArr(int[] arr) {
        int lastAvailableIndex = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(arr[0], lastAvailableIndex);
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                treeMap.put(arr[i], lastAvailableIndex);
            } else {
                lastAvailableIndex++;
                treeMap.put(arr[i], lastAvailableIndex);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " " + treeMap.get(arr[i]));
        }
    }
}


// Another version of array index compression
/*
         * Number compression
         */
        /*long[] tempCopy = new long[n];
        for (int i = 0; i < n; i++) {
            tempCopy[i] = temp[i];
        }
        Arrays.sort(tempCopy);
        int count = 1;
        Map<Long, Integer> map = new HashMap<>();
        map.put(tempCopy[0], count);
        for (int i = 1; i < n; i++) {
            if (tempCopy[i] != tempCopy[i - 1]) {
                count++;
            }
            map.put(tempCopy[i], count);
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = map.get(temp[i]);
        }
        */
