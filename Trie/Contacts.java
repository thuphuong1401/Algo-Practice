/*
https://www.hackerrank.com/challenges/contacts/problem
*/
import java.util.*;
import java.io.*;

/*
Question: find x => how many words having prefix x?
=> Solution: when add a new word, increment num of every new node added.
*/
class Node {
    public Node[] child;
    public int num; // number of words having prefix ending in this node
    
    public Node() {
        child = new Node[26];
        num = 0;
    }
}

class MyCode {
    static Node root;
    
    public static void addWord(Node root, String s) {
        int ch;
        Node temp = root;
        for(int i = 0; i < s.length(); i++) {
            ch = s.charAt(i) - 'a';
            if(temp.child[ch] == null) {
                Node x = new Node();
                temp.child[ch] = x;
            }
            temp = temp.child[ch];
            temp.num++;
        }
    }
    
    public static int findWord(Node root, String s) {
        int ch;
        Node temp = root;
        for(int i = 0; i < s.length(); i++) {
            ch = s.charAt(i) - 'a';
            if(temp.child[ch] == null) {
                return 0;
            }
            temp = temp.child[ch];
        }
        return temp.num;
    }
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        root = new Node();
        for(int i = 0; i < n; i++) {
            String op = scan.next();
            if(op.equals("add")) {
                String word = scan.next();
                addWord(root, word);
            } else {
                String query = scan.next();
                int ans = findWord(root, query);
                System.out.println(ans);
            }
        }
	}
}
