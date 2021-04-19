/*
https://codeforces.com/group/swEqtABRxe/contest/324151/problem/A
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            long a = scan.nextLong();
            long b = scan.nextLong();
            System.out.println(a + b - 1);
        }
    }
}
