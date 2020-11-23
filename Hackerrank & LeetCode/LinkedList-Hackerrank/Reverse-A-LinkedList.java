/*
https://www.hackerrank.com/challenges/reverse-a-linked-list/problem
Big idea: while iterating through the linked list:
- Save curr.next pointer (temp) so that we can find what is the next node to 'advance' to
- The next pointer of curr now points to prev
- prev advances to curr
- curr advances to temp (aka the saved curr.next before it was pointed to prev)
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
     
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode curr = head;
        if(curr == null || curr.next == null) {
            return curr;
        }
        while(curr != null) {
            SinglyLinkedListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private static final Scanner scanner = new Scanner(System.in);
