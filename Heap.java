/*
Heap implementation
Heaps are complete binary trees.
- minHeap: parent node < children. Top of heap is the smallest node.
- maxHeap: parent node > children. Top of heap is the largest node.
There are 4 main methods/operations: 
1. Build heap from a given array list
2. Find the smallest/largest element from a heap
3. Add an element to a heap
4. Delete an element from a heap
*/

import java.util.*;

public class Heap {
    public static List<Integer> heap;

    /*
    Helper method to swap element of index i and element of index j in an array list
    ArrayList.set(index, element)
    */
    private static void swap(int i, int j) {  
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /*
    Build a heap by calling minHeapify() from the "final" parent to the first parent
    int n will be the size of the array list
    */
    private static void buildMinHeap(int n) {
        for(int i = n/2 - 1; i >= 0; i--) {
            minHeapify(i);
        }
    }

    /*
    leftChild = index*2 + 1
    rightChild = index*2 + 2
    - Swap the current node with its smallest child
    - Call minHeapify() to make sure the heap property is maintained after swapping
    */
    public static void minHeapify(int i) {
        int current = i;
        int left = i*2+1;
        int right =  i*2 + 2;
        
        if(left < heap.size() && heap.get(left) < heap.get(current)) {
            current = left; 
        }

        if(right < heap.size() && heap.get(right) < heap.get(current)) {
            current = right;
        }

        if(current != i) {
            swap(current, i);
            minHeapify(current);
        }
    }

    /*
    Method to build a maxHeap
    */
    public static void buildMaxHeap(int n) {
        for(int i = n/2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    /*
    Same logic as minHeapify()
    */
    private static void maxHeapify(int i) {
        int current = i;
        int left = i*2 + 1;
        int right = i*2 + 2;

        if(left < heap.size() && heap.get(left) > heap.get(current)) {
            current = left;
        }

        if(right < heap.size() && heap.get(right) > heap.get(current)) {
            current = right;
        }

        if(current != i) {
            swap(current, i);
            maxHeapify(current);
        }
    } 

    /*
    Return the smallest/largest element of a heap
    */
    private static int top() {
        return heap.get(0);
    }

    /*
    Add an element to a minHeap
    - Append to the array list
    - Find its parents
    - Swap if violate min heap property
    */
    private static void addtoMinHeap(int e) {
        heap.add(e);
        int i = heap.size() - 1;
        while(i != 0 && heap.get((i-1) / 2) > heap.get(i)) {
            swap(i, (i-1)/2);
            i = (i-1)/2;
        }
    }

    /*
    Add an element to a maxHeap
    - Append to the array list
    - Find its parent
    - Swap if violate the max heap property 
    */
    private static void addToMaxHeap(int e) {
        heap.add(e);
        int i = heap.size() - 1;
        while(i != 0 && heap.get((i-1) / 2) < heap.get(i)) {
            swap(i, (i-1)/2);
            i = (i-1)/2;
        }
    }


    /*
    Delete the element at the top of the heap
    - Get last element of a heap
    - Copy last element to the first position
    - Delete last element 
    - percolateDown
    */
    private static void pop() {
        if(heap.size() == 0) {
            return;
        }

        int lastElem = heap.get(heap.size() - 1);
        heap.set(0, lastElem);
        heap.remove(heap.size()-1);

        minHeapify(0);

    }


    public static void main(String[] args) {
        heap = new ArrayList<Integer>(Arrays.asList(7, 12, 6, 10, 17, 15, 2, 4));

        buildMinHeap(heap.size());
        //buildMaxHeap(heap.size());
        addtoMinHeap(3);
        
        pop();

        for(int i : heap) {
            System.out.print(i + " ");
        }
    }

}
