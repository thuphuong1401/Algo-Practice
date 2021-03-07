/*
https://vjudge.net/problem/UVA-112
*/

import java.util.*;
import java.io.*;

class Node {
    int val;
    Node left;
    Node right;
    
    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class TempPair {
    Node node;
    int index;
    
    public TempPair(Node node, int index) {
        this.node = node;
        this.index = index;
    }
}

class MyCode {
	private static int n;
    
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            n = scan.nextInt();
            int open = 0;
            int close = 0;
            List<String> arr = new ArrayList<>();
            
            while(open == 0 || open != close) {
                String currLine = scan.next().trim();
                String lastNumber = "";
                for(char c : currLine.toCharArray()) {
                    if((c - '0' >= 0 && c - '0' <= 9) || c == '-') {
                        lastNumber += c;
                    } else {
                        if (lastNumber != "") {
                            arr.add(lastNumber);
                            lastNumber = "";
                        }
                        if(c == '(') {
                            open++;
                            arr.add(Character.toString(c));
                        } 
                        if(c == ')') {
                            close++;
                            arr.add(Character.toString(c));
                        }
                    }
                }
                if (lastNumber != "") {
                    arr.add(lastNumber);
                    lastNumber = "";
                }
            }
            
            if(arr.size() == 2 ) {
                if (n == 0) {
                    System.out.println("yes");
                }
                else {
                    System.out.println("no");
                }
            } else {
                Node root = new Node(Integer.parseInt(arr.get(1)));
                // arr.remove(0);
                // arr.remove(0);
                // arr.remove(arr.size() - 1);
                TempPair t = buildTree(arr, root, 0);
                //printTree(t.node);
                int sum = n;
                boolean ans = hasPathSum(t.node, sum);
                //boolean ans = hasPathSum(root, sum);
                //printTree(t.node);
                //boolean ans = true;
                if(ans) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
            arr.clear();
            //return;
        }      
	}
    
    // private static TempPair buildTree(List<String> arr, Node root, int lastIndex) {
    //     System.out.println(lastIndex);
    //     if(lastIndex == arr.size()) {
    //         return new TempPair(root, lastIndex);
    //     }
        
    //     if(arr.get(lastIndex).equals(")")) {
    //         return new TempPair(root, lastIndex);
    //     }
        
    //     if(arr.get(lastIndex).equals("(")) {
    //         TempPair pairLeft = buildTree(arr, root, lastIndex + 1);
    //         root.left = pairLeft.node;
    //         TempPair pairRight = buildTree(arr, root, pairLeft.index);
    //         root.right = pairRight.node;
    //         return new TempPair(root, pairRight.index);
    //     } else {
    //         int value = Integer.parseInt(arr.get(lastIndex));
    //         root = new Node(value);
    //         System.out.println("Created root with value " + root.val);
    //         return new TempPair(root, lastIndex);
    //     }
        
    // }     
    
    
    private static boolean isNumber(String s) {
        try {
            Integer sValue = Integer.parseInt(s);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    private static TempPair buildTree(List<String> arr, Node root, int curIndex) {
        if (curIndex == arr.size()) {
            return new TempPair(root, curIndex);    // root is null here
        }
        String curValue = arr.get(curIndex); 
        //System.out.println("Add: " + curValue);
        if (isNumber(curValue)) {
            // As root is null here, create new root to replace
            Node newRoot = new Node(Integer.parseInt(curValue));
            //System.out.println("Create left tree");
            TempPair pairLeft = buildTree(arr, newRoot.left, curIndex + 1);
            newRoot.left = pairLeft.node;
            //System.out.println("Create right tree");
            TempPair pairRight = buildTree(arr, newRoot.right, pairLeft.index);
            newRoot.right = pairRight.node;
            
            
            // // Parse the end symbol (")")
            TempPair pairEnd = buildTree(arr, root, pairRight.index);
            curIndex = pairEnd.index;
            return new TempPair(newRoot, curIndex);
        }
        if (curValue.equals("(") || curValue.equals(" ")) {
            // Upcoming number gonna be the value for the current node
            TempPair pairRoot = buildTree(arr, root, curIndex + 1);
            return pairRoot;
        }
        if (curValue.equals(")")) {
            // Finish parsing a tree branch
            return new TempPair(root, curIndex + 1);
        }
        
        return null;
    }
    
    
    private static void printTree(Node root) {
        if(root == null) {
            return;
        }    
        
        System.out.println(root.val);
        System.out.println("Left of " + root.val);
        printTree(root.left);
        System.out.println("Right of " + root.val);
        printTree(root.right);
    }
    
    
    
    private static boolean hasPathSum(Node root, int sum) {
        //if(root.left == null && root.right == null) {
        if (root == null) {
            return (sum == 0);
        }
        
        sum -= root.val;
        
        boolean hasLeftSum = hasPathSum(root.left, sum);
        boolean hasRightSum = hasPathSum(root.right, sum);
        
        return hasLeftSum || hasRightSum;
        
    }
    
}

