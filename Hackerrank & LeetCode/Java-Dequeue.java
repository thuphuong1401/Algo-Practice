/*
General idea: use deque to keep track of the sliding window
Use HashSet to count the number of unique elements
https://www.hackerrank.com/challenges/java-dequeue/problem
*/

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            set.add(num);

            if (deque.size() == m) {
                max = Math.max(max, set.size());
                int first = (int) deque.remove();
                /*
                 * If deque does not contain the element that we just removed (which implies
                 * that it's not there at all any more), we remove it from the set. The
                 * alternative, if deque still contained an element after we removed it, that
                 * would mean that there were at least two of those element in the sub-array,
                 * and so we have at least one left over. Therefore, it should still be
                 * considered part of the 'set'.
                 */
                if (!deque.contains(first)) {
                    set.remove(first);
                }
            }
        }
        System.out.println(max);
    }
}
