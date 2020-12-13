/*
https://www.hackerearth.com/practice/data-structures/advanced-data-structures/trie-keyword-tree/practice-problems/algorithm/search-engine/description/#:~:text=String%20Manipulation%2C%20Trees%2C%20Tries&text=Let%20us%20see%20how%20search,matching%20options%20among%20it's%20database.
*/
import java.util.*;
import java.io.*;

class Node {
    static final int MAX = 26;
    public Node[] child;
    public int maxWeightSoFar;
    public Node() {
        child = new Node[MAX];
        maxWeightSoFar = -1;
    }
}

class Trie {
    
    public static final int MAX = 26;
    private Node root;
    public Trie() {
        root = new Node();  
    }
    
    /*
    addWord() with modification: maxWeightSoFar records the max weight of all inserted words at a given node
    for ex: (abc 10), (abcd 20), (acbde 30) => a, b, c, d, e have maxWeightSoFar = 30.
    Test case: (hackerearth 10), (hackerrank 9) => 'hacker' has maxWeightSoFar = 10
    */
    public void addWord(String s, int weight) {
        int ch; 
        Node temp = this.root;
        for(int i = 0; i < s.length(); i++) {
            ch = s.charAt(i) - 'a';
            if(temp.child[ch] == null) {
                temp.child[ch] = new Node();
            }
            temp = temp.child[ch];
            temp.maxWeightSoFar = Math.max(temp.maxWeightSoFar, weight);
        }
    }
    
    public int findWordMaxWeight(String s) {
        int ch;
        Node temp = this.root;
        for(int i = 0; i < s.length(); i++) {
            ch = s.charAt(i) - 'a';
            if(temp.child[ch] == null) {
                return -1;    
            }
            temp = temp.child[ch];
        }
        return temp.maxWeightSoFar;
    }
    
}

class MyCode {
	
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        Trie trie = new Trie();
        int n = scan.nextInt();
        int q = scan.nextInt();
        for(int i = 0; i < n; i++) {
            String s = scan.next();
            int w = scan.nextInt();
            trie.addWord(s, w);
        }
        for(int i = 0; i < q; i++) {
            String query = scan.next();
            int ans = trie.findWordMaxWeight(query);
            System.out.println(ans);
        }
	  }
}
