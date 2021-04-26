/*
Monotonically decreasing stack - previous larger element
*/
import java.util.*;
import java.io.*;

class MyCode {
    
	public static void main (String[] args) {
        int[] arr = {1,2,7,4,3,6};
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            int ans = -1;
            if(!stack.isEmpty()) {
                ans = arr[stack.peek()];
            }
            System.out.print(ans + " ");
            
            stack.push(i);
        }

	}
}


