/*
https://www.codechef.com/problems/RRATING
*/

import java.io.*;
import java.util.*;

class MyCode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min heap, poll this to get min of top third
        int numOperations = scan.nextInt();
        int numberOfReviews = 0;
        for (int i = 0; i < numOperations; i++) {
            int op = scan.nextInt();
            /*
             * Idea: 1. If x > top of minHeap (the insertion of x directly affects the top
             * third, since it'll be in the top third) - Add x to minHeap - Poll the top of
             * minHeap, add such to maxHeap 2. Else - Add x to maxHeap (since it'll not
             * directly affects the top third). The 3rd condition will process such 3. If
             * maxHeap size % 3: - Add top of maxHeap to minHeap
             */
            if (op == 1) {
                numberOfReviews++;
                int x = scan.nextInt();
                if (minHeap.size() > 0 && x > minHeap.peek()) {
                    int polled = minHeap.remove();
                    maxHeap.add(polled);
                    minHeap.add(x);
                } else {
                    maxHeap.add(x);
                }
                if (numberOfReviews % 3 == 0) {
                    minHeap.add(maxHeap.remove());
                }
            } else if (op == 2) {
                if (minHeap.isEmpty()) {
                    System.out.println("No reviews yet");
                } else {
                    System.out.println(minHeap.peek());
                }
            }
        }
    }
}
