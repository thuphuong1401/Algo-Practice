/*
https://www.hackerrank.com/challenges/java-stack/problem
*/
import java.util.*;
class Solution{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String input = sc.next();
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < input.length(); i++) {
                Character bracket = input.charAt(i);
                if(!stack.isEmpty()) {
                    if(bracket.equals('}') && stack.peek().equals('{')) {
                        stack.pop();
                    } else if(bracket.equals(')') && stack.peek().equals('(')) {
                        stack.pop();
                    } else if(bracket.equals(']') && stack.peek().equals('[')) {
                        stack.pop();
                    } else {
                        stack.push(bracket);
                    }
                } else { 
                    stack.push(bracket);
                }
            }
            boolean answer = (stack.isEmpty()) ? true : false;
            System.out.println(answer);
		}
	}
}



