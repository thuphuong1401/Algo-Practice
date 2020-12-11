/*
https://www.hackerrank.com/challenges/reduced-string/problem
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        String answer = "";
        Stack<Character> stack =  new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(stack.isEmpty()) {
                stack.push(curr);
            } else {
                if(stack.peek().equals(curr)) {
                    stack.pop();
                } else {
                    stack.push(curr);
                }
            }
        }
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }
        if(answer.equals("")) {
            return "Empty String";
        } else {
            return reverse(answer);
        }
    }
    
    static String reverse(String s) {
        String answer = "";
        for(int i = s.length()-1; i >= 0; i--) {
            answer += s.charAt(i);
        }
        return answer;
    } 
   

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
