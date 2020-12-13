/*
https://vjudge.net/problem/LightOJ-1224
Question: find a subset such that |longest common prefix| * num_samples is maximum
*/
import java.util.*;
import java.io.*;

class Node {
    Node[] child;
    int numWords; // records the number of words with prefix ending at this node (so far)
    
    public Node () {
        child = new Node[4];
        numWords = 0;
    }
}

class MyCode {
    
    static int[] dna = new int[26];
    static int answer = 0;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        dna['A' - 'A'] = 0;
        dna['C' - 'A'] = 1;
        dna['G' - 'A'] = 2;
        dna['T' - 'A'] = 3;
        int numTestCases = scan.nextInt();
        for(int i = 0; i < numTestCases; i++) {
            int n = scan.nextInt();
            Node root = new Node();
            for(int j = 0; j < n; j++) {
                String s = scan.next();
                addWord(root, s);
            }
            System.out.println("Case " + (i+1) + ": " + answer);
            answer = 0;
        }
	}
    
    public static void addWord(Node root, String s) {
        int ch;
        Node temp = root;
        for(int i = 0; i < s.length(); i++) {
            ch = dna[s.charAt(i) - 'A'];
            if(temp.child[ch] == null) {
                temp.child[ch] = new Node();
            }
            // increment temp.numWords AFTER moving the pointer to temp.child[ch]
            temp = temp.child[ch];  
            temp.numWords++;
            /*
            temp.numWords = num_samples containing prefix ending in temp.child[ch]
            i+1: length of current longest common prefix
            */
            answer = Math.max(answer, temp.numWords * (i+1));
        }
    }
    
}
