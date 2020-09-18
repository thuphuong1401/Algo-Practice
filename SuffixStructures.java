/*
Souce: Big-O Blue class - Codeforces
*/
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
    String str1 = scan.next();
    String str2 = scan.next();
    
    // conditions
    if(automaton(str1, str2)) {
      System.out.println("automaton");
    } else if (reverse(str1, str2)) {
      System.out.println("array");
    } else if(treeTest(str1, str2)) {
      System.out.println("need tree");
    } else {
      System.out.println("both");
    }
  }
    // use only automaton
    public static boolean automaton(String s1, String s2) {
      if(s1.length() > s2.length()) {
        int j = 0;
        for(int i=0; i < s1.length(); i++) {
          if(s1.charAt(i) == s2.charAt(j)) {
            if(j==s2.length()-1) {
          		return true;
        		}
            j++;
          }
        }
        
      } 
      return false;
    } 
    
    // use only array
    public static boolean reverse(String s1, String s2) {
      if(s1.length() == s2.length()) {
        int[] count1 = new int[150];
        int[] count2 = new int[150];
        for(int i=0; i<s1.length();i++) {
          count1[s1.charAt(i)] += 1;
        }
        for(int j=0; j<s2.length();j++) {
          count2[s2.charAt(j)] += 1;
        }
        for(int k=0; k<count1.length; k++) {
          if(count1[k] != count2[k]) {
            break;
          }
          if(k==count1.length-1 && count1[k] == count2[k]) {
            return true;
          }
        }
      }
      return false;
    }
    
    // need tree or not
    // is there a char in s2 that isn't in s1?
    public static boolean treeTest(String s1, String s2) {
      int[] count1 = new int[150];
      int[] count2 = new int[150];
      for(int i=0; i<s1.length();i++) {
        count1[s1.charAt(i)] += 1;
      }
      for(int j=0; j<s2.length();j++) {
        count2[s2.charAt(j)] += 1;
      }
      int diff = 0;
      for(int k=0; k < count1.length; k++) {
        diff = count1[k] - count2[k];
        if(diff < 0) {
          //System.out.println(diff);
          return true;
        }
      }
      return false;
    }
 }
