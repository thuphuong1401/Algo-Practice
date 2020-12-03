/*
https://www.hackerrank.com/challenges/migratory-birds/problem
A Priority Queue approach - it works, yay!
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Node implements Comparable<Node> {
    public Integer type;
    public Integer freq;
    
    public Node(Integer type, Integer freq) {
        this.type = type;
        this.freq = freq;
    }
    
    @Override
    // prioritize 1. higer freq and 2. lower id
    public int compareTo(Node other) {
        if(this.freq.equals(other.freq)) {
            return this.type.compareTo(other.type);
        }
        return other.freq.compareTo(this.freq);
    }
}

public class Solution {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int MAX = (int) 1e6;
        int[] freqCount = new int[MAX];
        for(int i = 0; i < arr.size(); i++) {
            freqCount[arr.get(i)]++;
        }
        for(int i = 0; i < MAX; i++) {
            if(MAX != 0) {
                pq.add(new Node(i, freqCount[i]));
            }
        }
        Node top = pq.remove();
        return (int)top.type;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr.add(arrItem);
        }

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
