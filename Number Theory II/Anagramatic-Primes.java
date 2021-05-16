/*
https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=838
*/ 
import java.util.*;
import java.io.*;

class MyCode {

    static final int MAX = (int) 1e7;
    static final int MAXint = (int) 1e6;
    static Map<Integer, Boolean> isAnagramatic;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        isAnagramatic = new HashMap<>();
        segmentedSieve(MAX);
        anagramatic();

        while (true) {
            int n = scan.nextInt();
            if (n == 0) {
                break;
            }
            int numOfDigit = numDigit(n);
            int upperBound = (int) Math.pow(10, numOfDigit);
            boolean flag = false;
            for (int num = n + 1; num < upperBound; num++) {
                if (isAnagramatic.containsKey(num) && isAnagramatic.get(num)) {
                    // System.out.print(permutation(num));
                    System.out.println(num);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println(0);
            }
        }

    }

    private static void anagramatic() {
        Set<Integer> primes = new HashSet<>();
        for (int p : isAnagramatic.keySet()) {
            primes.add(p);
        }
        //// System.out.println(primes);
        for (int p : primes) {
            if (!isAnagramatic.get(p)) {
                continue;
            }
            if (!anagramIsPrime(p) && numDigit(p) > 1) {
                isAnagramatic.put(p, false);
                continue;
            }

            List<Integer> permutationOfp = permutation(p);

            boolean flag = false;
            for (int num : permutationOfp) {
                if (!isAnagramatic.containsKey(num)) {
                    flag = true;
                }
            }
            if (flag) {
                for (int num : permutationOfp) {
                    if (isAnagramatic.containsKey(num)) {
                        isAnagramatic.put(num, false);
                    }
                }
            }
        }

    }

    private static boolean anagramIsPrime(int p) {
        while (p != 0) {
            int digit = p % 10;
            p /= 10;
            if (digit % 2 == 0 || digit == 5) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> permutation(int n) {
        List<Integer> ans = new ArrayList<>();
        String s = Integer.toString(n);
        char[] arr = s.toCharArray();
        // System.out.println("S: " + s);
        ans = helper(arr, new ArrayList<>(), 0);
        return ans;
    }

    private static List<Integer> helper(char[] arr, List<Integer> list, int l) {

        if (l >= arr.length) {
            // System.out.println(String.valueOf(arr));
            list.add(Integer.parseInt(String.valueOf(arr)));
            return list;
        }

        for (int i = l; i < arr.length; i++) {
            char temp = arr[l];
            arr[l] = arr[i];
            arr[i] = temp;
            list = helper(arr, list, l + 1);
            temp = arr[l];
            arr[l] = arr[i];
            arr[i] = temp;
        }

        return list;
    }

    private static int numDigit(int n) {
        int ans = 0;
        while (n != 0) {
            ans++;
            n /= 10;
        }
        return ans;
    }

    private static void segmentedSieve(int n) {
        int S = 10000;
        List<Integer> tempPrimes = new ArrayList<>();

        int nsqrt = (int) Math.sqrt(n);
        boolean[] is_prime = new boolean[nsqrt + 1];
        Arrays.fill(is_prime, true);
        for (int i = 2; i <= nsqrt; i++) {
            if (is_prime[i]) {
                tempPrimes.add(i);
                for (int j = i * i; j <= nsqrt; j += i) {
                    is_prime[j] = false;
                }
            }
        }

        boolean[] block = new boolean[S];
        for (int k = 0; k * S <= n; k++) {
            Arrays.fill(block, true);
            int start = k * S;
            for (int p : tempPrimes) {
                int start_idx = (start + p - 1) / p;
                int j = Math.max(start_idx, p) * p - start;
                for (; j < S; j += p) {
                    block[j] = false;
                }
            }
            if (k == 0) {
                block[0] = block[1] = false;
            }
            for (int i = 0; i < S && start + i <= n; i++) {
                if (block[i]) {
                    isAnagramatic.put(i + start, true);
                }
            }
        }
    }

}
