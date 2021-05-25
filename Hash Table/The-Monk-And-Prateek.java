/*
https://www.hackerearth.com/challenges/competitive/code-monk-hashing-1/algorithm/the-monk-and-prateek/
*/
import java.util.*;
import java.io.*;

class MyCode {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextLong();
        }
        Map<Long, Long> freqF = new HashMap<>();

        long maxFreq = 1L;
        long maxHashed = 0L;
        long minHashed = Long.MAX_VALUE;
        long collision = 0;

        for (long num : arr) {
            long hashed = f(num);

            if (freqF.containsKey(hashed)) {
                collision++;
                freqF.put(hashed, freqF.get(hashed) + 1L);
            } else {
                freqF.put(hashed, 1L);
            }

            if (freqF.get(hashed) == maxFreq) {
                maxHashed = Math.max(maxHashed, hashed);
                minHashed = Math.min(minHashed, hashed);

            } else if (freqF.get(hashed) > maxFreq) { // maxFreq != 1
                minHashed = hashed;
                maxHashed = hashed;
                maxFreq = freqF.get(hashed);
            }

            // System.out.println(hashed + " | " + minHashed + ", " + maxHashed + ", " +
            // maxFreq);
        }

        if (maxFreq == 1L) {
            System.out.println(maxHashed + " " + collision);
        } else {
            System.out.println(minHashed + " " + collision);
        }
    }

    public static long f(long n) {
        long sum = 0;
        long x = n;
        while (x > 0L) {
            sum += x % 10;
            x /= 10;
        }
        return (n ^ sum);
    }

}
