/*
https://vjudge.net/problem/LightOJ-1129
*/
import java.util.*;
import java.io.*;

class Node {
    public Node[] child;
    public int countWord;
    
    public Node() {
        child = new Node[10];
        countWord = 0;
    }
}

class MyCode {
    
    public static boolean addWord(Node root, String s) {
        int ch;
        Node temp = root;
        for(int i = 0; i < s.length(); i++) {
            ch = s.charAt(i) - '0';
            if(temp.child[ch] == null) {
                Node x = new Node();
                temp.child[ch] = x;
            }
            
            // do this before checking whether temp.countWord == 1
            temp = temp.child[ch]; // move to current s.charAt(i) in trie
            
            if(temp.countWord == 1) {
                return false;
            }
        }
        temp.countWord++;
        return true;
    }
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        for(int j = 0; j < numTestCases; j++) {
            int n = scan.nextInt();
            Node root = new Node();
            long[] arr = new long[n];
            boolean consistent = true;
            for(int i = 0; i < n; i++) {
                arr[i] = scan.nextLong();
            }
            Arrays.sort(arr); // shorter numbers are inserted first   
            for(int i = 0; i < n; i++) {
                String s = Long.toString(arr[i]);
                consistent = addWord(root, s);
                if(!consistent) {
                    System.out.println("Case " + (j+1) + ": NO");
                    break;
                }
            }
            if(!consistent) {
                continue;
            } else {
                System.out.println("Case " + (j+1) + ": YES");
            }
        }
        
	}
}

