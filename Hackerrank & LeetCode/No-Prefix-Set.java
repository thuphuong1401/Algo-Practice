/*
https://www.hackerrank.com/challenges/no-prefix-set/problem
*/
import java.util.*;
import java.io.*;

class Node {
    public Node[] child;
    public int countWord;
    
    public Node() {
        child = new Node[11]; // only a-j
        countWord = 0;
    }
}

class Solution {
    static String badWord = "";
    
    public static boolean addWord(Node root, String s) {
        int ch;
        Node temp = root;
        for(int i = 0; i < s.length(); i++) {
            ch = s.charAt(i) - 'a';
            if(temp.child[ch] == null) {
                Node x = new Node();
                temp.child[ch] = x;
            }
            temp = temp.child[ch];
            if(temp.countWord > 0) {
                badWord = s;
                return false;
            }
        }
        temp.countWord++;
        for(int i = 0; i < 11; i++) {
            if(temp.child[i] != null) {
                badWord = s;
                return false;
            }
        }
        return true;
    }
    
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Node root = new Node();
        for(int i = 0; i < n; i++) {
            String s = scan.next();
            boolean output = addWord(root, s);
            if(!output) {
                System.out.println("BAD SET");
                System.out.println(badWord);
                return;
            }
        }
        System.out.println("GOOD SET");
    }
}

