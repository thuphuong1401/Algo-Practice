/*
https://codeforces.com/problemset/problem/835/B
*/
import java.util.*;
import java.io.*;

/*
Big idea:
- Chọn số nhỏ nhất để fill diff vào (vì nó sẽ ít ảnh hưởng đến các số khác nhất)
*/
class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        long k = scan.nextLong();
        String n = scan.next();
        long total = 0;
        int[] freq = new int[10];
        for(char c : n.toCharArray()) {
            int temp = c - '0';
            total += temp;
            freq[temp]++;
        }
        long diff = k - total;
        if(diff <= 0) {
            System.out.println(0);
            return;
        }
        int placeDiff = 0;
        for(int i = 0; i <= 9; i++) {
            while(freq[i] > 0 && diff > 0) {
                int fill = 9 - i;
                diff -= fill;
                freq[i]--;
                placeDiff++;
            }
        }
        System.out.println(placeDiff);
	}
}



// Cach 2
import java.util.*;
import java.io.*;

/*

n = 1112
freq[] = [0, 3, 1]

diff = 17
fill mot so 1: + 8
17 - x * 8 <= 0 
=> 17 <= x * 8 <=> x = ceil(17/8) = 3
*/

class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        long k = scan.nextLong();
        String n = scan.next();
        long total = 0;
        int[] freq = new int[10];
        for(char c : n.toCharArray()) {
            int temp = c - '0';
            total += temp;
            freq[temp]++;
        }
        long diff = k - total;
        if(diff <= 0) {
            System.out.println(0);
            return;
        }
        int placeDiff = 0;
        for(int i = 0; i < 9 && diff > 0; i++) {
            int increment  = (int)Math.ceil((float)diff / (float)(9 - i));
            increment = Math.min(increment, freq[i]);
            placeDiff += increment;
            diff -= increment * (9-i);
        }
        System.out.println(placeDiff);
	}
}


