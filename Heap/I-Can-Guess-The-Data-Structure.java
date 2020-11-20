/*
https://www.programmersought.com/article/8693830315/
*/

import java.io.*;
import java.util.*;

class MyCode {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (scan.hasNext()) {

            int n = scan.nextInt();
            boolean isStack = true;
            boolean isQueue = true;
            boolean isPQ = true;

            for (int i = 0; i < n; i++) {
                int op = scan.nextInt();
                if (op == 1) {
                    int toAdd = scan.nextInt();
                    stack.add(toAdd);
                    queue.add(toAdd);
                    pq.add(toAdd);
                } else {
                    int toRemove = scan.nextInt();

                    if (!stack.isEmpty()) {
                        int pop = stack.pop();
                        if (pop != toRemove) {
                            isStack = false;
                        }
                    }

                    if (!queue.isEmpty()) {
                        int pop = queue.remove();
                        if (pop != toRemove) {
                            isQueue = false;
                        }
                    }

                    if (!pq.isEmpty()) {
                        int pop = pq.remove();
                        if (pop != toRemove) {
                            isPQ = false;
                        }
                    }
                }
            }

            /*
             * System.out.println("stack: " + isStack); System.out.println("queue: " +
             * isQueue); System.out.println("pq: " + isPQ); System.out.println();
             */

            // Check the booleans
            if (isStack && isQueue || isStack && isPQ || isQueue && isPQ) {
                System.out.println("not sure");
            } else if (isStack == false && isQueue == false && isPQ == false) {
                System.out.println("impossible");
            } else if (isStack) {
                System.out.println("stack");
            } else if (isQueue) {
                System.out.println("queue");
            } else if (isPQ) {
                System.out.println("priority queue");
            }

            // CLear all to prepare for the next test case
            stack.clear();
            queue.clear();
            pq.clear();
        }
    }
}
