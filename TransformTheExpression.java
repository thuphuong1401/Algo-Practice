import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int numCases = scan.nextInt();
    Stack<Character> s = new Stack<>();
    
    for(int i=0; i<numCases; i++) {
      char[] expression = scan.next().toCharArray();
      for(Character symbol : expression) {
        if(Character.isLetter(symbol)) {
          System.out.print(symbol);
        }
        else if(symbol.equals(')')) {
         	System.out.print(s.pop());
        }
        else if(!symbol.equals('(')) {
          s.add(symbol);
        }
      }
      System.out.println();
    }
  }
}



