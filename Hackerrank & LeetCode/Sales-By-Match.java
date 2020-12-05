/*
https://www.hackerrank.com/challenges/sock-merchant/problem
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Sock {
    int id;
    boolean visited;
    public Sock(int id, boolean visited) {
        this.id = id;
        this.visited = visited;
    }
}

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] arr) {
        int pairs = 0;
        Sock[] arrOfSocks = new Sock[arr.length];
        for(int i = 0; i < arr.length; i++) {
            arrOfSocks[i] = new Sock(arr[i], false);
        }
        for(int i = 0; i < arrOfSocks.length-1; i++) {
            Sock currSock = arrOfSocks[i];
            for(int j = i+1; j < arrOfSocks.length; j++) {
                if(currSock.id == arrOfSocks[j].id && currSock.visited == false &&arrOfSocks[j].visited == false) {
                    pairs++;
                    arrOfSocks[j].visited = true;
                    break;
                }
            }
            currSock.visited = true;
        }
        return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
