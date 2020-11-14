/*
https://codeforces.com/problemset/problem/518/A
*/

import java.util.Scanner;
import java.lang.*; 
import java.util.ArrayList;

public class VitalyAndStrings {

  public static boolean lexNext(String sstr, String tstr) {
    int f = 0;
    ArrayList<Character> overlap = new ArrayList<>();
    while(sstr.charAt(f) == tstr.charAt(f)) {
      overlap.add(sstr.charAt(f));
      f++;
    }
    if(overlap.size() == sstr.length()-1 && tstr.charAt(tstr.length()-1) - sstr.charAt(sstr.length()-1) <= 1) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = scan.next();
    String t = scan.next();
    int n = s.length();
    char[] temp = new char[n];
    String comp = "";
    int curr = 0;
    char holder = 'a';

    // Copy s over to temp
    for (int j = 0; j < n; j++) {
      temp[j] = s.charAt(j);
    }
    
    if(lexNext(s, t)) {
      System.out.println("No such string");
      System.exit(0);
    }

    for (int i = n-1; i >= 0; i--) {
      while(s.charAt(i) < 'z') {
        curr = (int)s.charAt(i);
        curr++;
        holder = (char) curr;
        temp[i] = holder;
        comp = String.valueOf(temp);
        if (t.compareTo(comp) > 0) { // T is lexicographically greater than comp
          System.out.println(comp);
          System.exit(0);
        }
        System.out.println(i);
      } 
      if (s.charAt(i) == 'z') {
        holder = 'a';
        temp[i] = holder;
      }
    }

  }
}
