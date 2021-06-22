/*
https://www.byte-by-byte.com/nstacks/
*/
import java.util.*;
import java.io.*;

class Stacks {
    
    int[] stackData; // contains stack data
    int[] topOfStacks; // contains INDEX of top of stacks
    int[] nextIndex; // index of free slot in stackData array
    int nextAvailable = 0; // index
	
    
    public Stacks(int numStacks, int capacity) {
        topOfStacks = new int[numStacks];
        Arrays.fill(topOfStacks, -1);
        stackData = new int[capacity];
        nextIndex = new int[capacity];
        for(int i = 0; i < capacity - 1; i++) {
            nextIndex[i] = i+1;
        }
        nextIndex[capacity-1] = -1;
    }
    
    // push int(value) into stack-th stack
    public void push(int stack, int value) {
        if(stack < 0 || stack >= this.topOfStacks.length) {
            throw new IndexOutOfBoundsException();
        }
        
        if(nextAvailable < 0) {
            return;
        }
        
        int currentIndex = nextAvailable;
        nextAvailable = nextIndex[currentIndex];
        nextIndex[currentIndex] = topOfStacks[stack];
        topOfStacks[stack] = currentIndex;
        stackData[currentIndex] = value;
        
    }
    
    
    public int pop(int stack) {
        if(stack < 0 || stack >= this.topOfStacks.length || topOfStacks[stack] == -1) {
            throw new IndexOutOfBoundsException();
        }
        
        int currentIndex = topOfStacks[stack];
        int value = stackData[currentIndex];
        topOfStacks[stack] = nextIndex[currentIndex];
        nextIndex[currentIndex] = nextAvailable;
        nextAvailable = currentIndex;
        
        return value;
        
    }
    
    
}
