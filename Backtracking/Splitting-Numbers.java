/*
https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=3084
*/

/*
Cần split 1 số n thành 1 số a và b, sao cho a chỉ chứa các bit 1 ở thứ tự chẵn, b chỉ chứa các bit 1 ở thứ tự lẻ
n là integer => có 31 bit
Idea là nếu (n & (1 << i)) > 0 (bit thứ i là 1) và đây là vị trí chẵn, cộng 1 << i vào a, nếu là vị trí lẻ thì cộng vào b.
*/
import java.util.*;
import java.io.*;

class MyCode {
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            int n = scan.nextInt();
            if(n == 0) {
                return;
            }
            
            boolean isEven = true;
            int a = 0, b = 0;
            for(int i = 0; i <= 30; i++) {
                if((n & (1 << i)) > 0) {
                    if(isEven) {
                        a += 1 << i;
                    } else {
                        b += 1 << i;
                    }
                    
                    isEven = !isEven;
                }
            }
            System.out.println(a + " " + b);
        }

	}
}
