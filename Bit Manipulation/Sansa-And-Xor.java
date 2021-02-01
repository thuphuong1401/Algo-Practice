/*
https://www.hackerrank.com/challenges/sansa-and-xor/problem

Note: công thức tính số lần xuất hiện của arr[i]: (n-i) * (i+1)

(i+1): số cách chọn điểm bắt đầu của đoạn chứa arr[i]
(n-i): số cách chọn điểm kết thúc của đoạn chứa arr[i]
Giải thích: 
*/
import java.util.Scanner;

class Solution {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        while (numTestCases-- > 0) {
            int n = scan.nextInt();
            int [] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scan.nextInt();
            }
            if (n % 2 == 0) { // Case 1
                System.out.println(0);
            } else { // Case 2
                int result = 0;
                for (int i = 0; i < n; i++) {
                    if (i % 2 == 0) {
                        result ^= array[i];
                    }
                }
                System.out.println(result);
            }
        }
    }
}
