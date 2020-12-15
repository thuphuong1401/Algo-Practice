/*
https://www.urionlinejudge.com.br/judge/en/problems/view/1313
*/
import java.io.*;
import java.util.*;

class Node {
    public Node[] child;
    public int countWord;
    
    public Node() {
        child = new Node[26];
        countWord = 0;
    }
}

class MyCode {
                
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            int p = scan.nextInt();
            int s = scan.nextInt();
            Node rootP = new Node();
            Node rootS = new Node();
            if(p == 0 && s == 0) {
                break;
            }
            for(int i = 0; i < p; i++) {
                String string = scan.next();
                addWord(rootP, string);
            }
            for(int i = 0; i < s; i++) {
                String string = scan.next();
                string = reverse(string);
                addWord(rootS, string);
            }
            
            // prefixEndAt['a'] ~ số lượng node 'a' trong cây trie Prefix 
            int[] prefixEndAt = traverse(rootP);
            int[] suffixEndAt = traverse(rootS);
            
            long numPrefix = numNode(rootP);
            long numSuffix = numNode(rootS);
            long overlap = 0;
            
            for(int i = 0; i < 26; i++) {
                overlap += prefixEndAt[i] * suffixEndAt[i]; // khong tinh nhung prefix & suffix co 1 ki tu
            }
            long answer = numPrefix * numSuffix - overlap;
            System.out.println(answer);
        } 
	}
    
    public static long numNode(Node root) {
        return numNode(root, 0);
    }
    
    private static long numNode(Node root, long answer) {
        Node temp = root;
        for(int i = 0; i < 26; i++) {
            if(temp.child[i] != null) {
                answer = 1 + numNode(temp.child[i], answer);
            }    
        }
        return answer;        
    }
    
    public static String reverse(String s) {
        String answer = "";
        for(int i = s.length()-1; i >= 0; i--) {
            answer += s.charAt(i);
        }
        return answer;
    }
    
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
        }
    }
    
    // đếm số node ('a', 'b', etc.) trong trie. Ghi đáp án vào mảng answer 
    public static int[] traverse(Node root) {
        int[] answer = new int[26];
        answer = traverse(root, answer, 0);
        return answer;
    }
    
    private static int[] traverse(Node root, int[] arr, int level) {
        Node temp = root;
        for(int i = 0; i < 26; i++) {
            if(temp.child[i] != null) {
                if(level >= 1) { // not taking into account prefixes and suffixes having 1 character (no overlap happens)
                    arr[i] = arr[i] + 1;
                }
                arr = traverse(temp.child[i], arr, level+1);
            }    
        }
        return arr;        
    }

}


/*
1 5
aa
-----
aaa
aaaa

prefix: a, aa
suffix: a, aa, aaa, aaaa

Nếu xét các từ có độ dài là n
prefix[-1] = 'X'
suffix[0] = 'X'
Do dai 3
prefix: a
suffix: aa


aa, aaa, aaaa, aaaaa
aaa, aaaa, aaaaa, 
=> trung
n_prefix x n_suffix - giao
Giao: 

giao: 
abXcde
=> ab, Xcbe
=> abX, cbe

prefix: abc, adcdc
suffix: cdef
số lượng bị trùng do kết thúc và bắt đầu tại ký tự 'c':
số lượng prefix kết thúc tại 'c' x số lượng suffix .. 'c'

s['a'] x p['a'] + s['b'] x p['b']


- Cây trie suffix ko, prefix ko
- Thử ghép suffix, prefix -> lấy s = suffix + prefix -> trie (loại trùng) -> số node

Prefix có thể kết thúc tại ký tự X và suffix có thể bắt đầu tại ký tự X

- Cây trie suffix, prefix
*/


