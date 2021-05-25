/*
https://www.spoj.com/problems/SUFEQPRE/
*/
import java.util.*;
import java.io.*;

class MyCode {
    static String s;
    static final int base = 26;
    static final long[] MOD = { (int) 1e9 + 2277, (int) 1e9 + 9277 };
    static final int numMOD = MOD.length;
    static final int MAX = (int) (1e6) + 1;
    static long POW[][];
    static long hashT[][];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            String t = scan.next();
            int n = t.length();
            s = " " + t;

            POW = new long[numMOD][MAX];
            for (int j = 0; j < numMOD; j++) {
                POW[j][0] = 1;
            }
            hashT = new long[numMOD][MAX];

            // hash of str[0...i] = x_0 * a^n + x_1 * a^(n-1) + ... + x_i * a^(n-i)
            // s = "abcd"
            // base = 33
            // hash(a) = ascii(a) * 1
            // hash(b) = ascii(a) * 33 + ascii(b) = hash(a) * 33 + ascii(b)
            // hash(c) = ascii(a) * 33^2 + ascii(b) * 33 + ascii(c) = hash(b) * 33 +
            // ascii(c)
            // hash(T_i) = hash(T_{i-1}) * base + ascii(s[i])

            for (int j = 0; j < numMOD; j++) {
                for (int i = 1; i <= n; i++) {
                    POW[j][i] = (POW[j][i - 1] * base) % MOD[j];
                }
            }

            for (int j = 0; j < numMOD; j++) {
                for (int i = 1; i <= n; i++) {
                    hashT[j][i] = (hashT[j][i - 1] * base + s.charAt(i) - 'a' + 1) % MOD[j];
                }
            }

            int cnt = 0;
            for (int i = 1; i < n; i++) {
                boolean flag = true;
                for (int j = 0; j < numMOD; j++) {
                    long hashPrefix = getHashT(1, i, j);
                    long hashedSuffix = getHashT(n - i + 1, n, j);
                    if (hashPrefix != hashedSuffix) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    cnt++;
                }
            }
            System.out.println("Case " + testCase + ": " + cnt);
        }

    }

    // hash of str[0...i] = x_0 * a^n + x_1 * a^(n-1) + ... + x_i * a^(n-i)
    // s = "abcde"
    // base = 33
    // hash(a) = ascii(a) * 1
    // hash(b) = ascii(a) * 33 + ascii(b) = hash(a) * 33 + ascii(b)
    // hash(c) = ascii(a) * 33^2 + ascii(b) * 33 + ascii(c)
    // hash(e) = ascii(a) * 33^4 + ascii(b) * 33^3 + ascii(c) * 33^2 + ascii(d) * 33
    // + ascii(e)

    // hash(c..e) = ascii(c) * 33^2 + ascii(d)*33 + ascii(e)
    // = hash(b) * base^(j-i+1)
    private static long getHashT(int i, int j, int indexMOD) {
        return (hashT[indexMOD][j] - hashT[indexMOD][i - 1] * POW[indexMOD][j - i + 1] + MOD[indexMOD] * MOD[indexMOD])
                % MOD[indexMOD];
    }

}
