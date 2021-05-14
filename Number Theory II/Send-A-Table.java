/*
https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=1761
*/
import java.util.*;
import java.io.*;

/*
Ans(x, y) where x = y can be deduced from Ans(1, 1)
Suppose x < y:
- If gcd(x, y) > 1: Ans(x, y) can be deduced from Ans(x/gcd(x, y), y/gcd(x, y))
- If gcd(x, y) = 1: have to spend 1 calculation on Ans(x, y) and 1 more on Ans(y, x)
Therefore for each y (2 <= y <= N), we need to spend phi(y) calculations.
*/
class MyCode {
    
    static final int MAX = 50001;
    static int[] dp;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        dp = new int[MAX];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i < MAX; i++) {
            dp[i] = phi(i);
        }
        while(true) {
            int n = scan.nextInt();
            if(n == 0) {
                return;
            }
            int ans = 1; // Ans(1, 1)
            for(int i = 2; i <= n; i++) {
                ans += 2 * phi(i);
            }
            System.out.println(ans);
        }   
    }    
    
    private static int phi(int n) {
        int result = n;
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                while(n % i == 0) {
                    n /= i;
                }
                result = result / i * (i - 1);
            }
        }
        if(n > 1) {
            result = result / n * (n - 1);
        }
        return result;
    }
}
