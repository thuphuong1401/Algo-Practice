/*
https://www.hackerrank.com/challenges/extra-long-factorials/problem
*/
import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        int n = (new Scanner(System.in)).nextInt();
        BigInteger factorial = new BigInteger("1");
        while (n > 1){
            factorial = factorial.multiply(BigInteger.valueOf(n));
            n--;
        }
        System.out.println(factorial);
    }
}
