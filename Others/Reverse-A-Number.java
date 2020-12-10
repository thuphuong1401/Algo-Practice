import java.util.*;
import java.io.*;

class MyCode {
    
    static int reverse(int d) {
        int reverse = 0;
        int temp = d;
        int length = 0;
        while(temp > 0) {
            temp = temp/10;
            length++;
        }
        int counter = length-1; 
        while(counter >= 0) {
            reverse += (d%10) * Math.pow(10, counter); 
            counter--;
            d = d/10;
        }
        return reverse;
    }
    
	public static void main (String[] args) {
        int x = 200;
        System.out.println(reverse(x));    
	}
}
