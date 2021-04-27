/*
https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=1068
Sử dụng tính chất phân phối c
*/
import java.util.*;
import java.io.*;

class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            int ans = 1;
            int count = 1;
            while(ans % n != 0) {
                ans = ((ans * 10) + 1) % n;
                count++;
            }
            System.out.println(count);
        }      
	}
}
