/*
https://codeforces.com/problemset/problem/515/B
*/
import java.util.*;
import java.io.*;

class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int b = scan.nextInt();
        int[] arrBoys = new int[b];
        boolean[] happyBoys = new boolean[n];
        for(int i = 0; i < b; i++) {
            arrBoys[i] = scan.nextInt();
            happyBoys[arrBoys[i]] = true;
        }
        int g = scan.nextInt();
        int[] arrGirls = new int[g];
        boolean[] happyGirls = new boolean[m];
        for(int i = 0; i < g; i++) {
            arrGirls[i] = scan.nextInt();
            happyGirls[arrGirls[i]] = true;
        }
        
        int lcm = n * m / gcd(n, m);
        int unhappyBoys = n - b;
        int unhappyGirls = m - g;
        for(int day = 0; day < 2 * lcm; day++) {
            int currBoy = day % n;
            int currGirl = day % m;
            if(happyBoys[currBoy] && !happyGirls[currGirl]) {
                happyGirls[currGirl] = true;
                unhappyGirls--;
            }
            if(happyGirls[currGirl] && !happyBoys[currBoy]) {
                happyBoys[currBoy] = true;
                unhappyBoys--;
            }
        }
        
        if(unhappyBoys == 0 && unhappyGirls == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
	}
    
    private static int gcd(int a, int b) {
        int r;
        while(b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
    
}

/*
LCM(n, m)


0 1 2 3
0 1 2 3 4 5

Muc tieu: lam the nao de boy 0th va girl 0th gap lai nhau lan thu 2?
lan thu hai (0, 0): LCM(n, m)
lan thu hai (1, 1): LCM(n, m) + 1
...
lan thu hai ((n - 1), (m - 1)): LCM(n, m) + LCM(n, m)

n-1, m-1 

0 -> 2*LCM(n, m)
*/
