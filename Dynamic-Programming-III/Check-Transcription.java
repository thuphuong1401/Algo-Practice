/*
https://codeforces.com/problemset/problem/1056/E
*/

import java.util.*;
import java.io.*;

class MyCode {
    static final int MAX = (int) (1e6) + 5;
    static final long MOD = (int) (1e9) + 7;
    static String s, t;
    static int lenS, lenT;
    static long pre[], ppow[];
    static long seed = 133; // base

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sIn = scan.next();
        String tIn = scan.next();

        lenS = sIn.length();
        lenT = tIn.length();

        s = " " + sIn;
        t = " " + tIn;

        int tot0 = 0;
        int tot1 = 0;

        for (int i = 1; i <= lenS; i++) {
            if (s.charAt(i) == '0') {
                tot0++;
            } else {
                tot1++;
            }
        }
        calculateHash();

        int ans = 0;
        int lenr0 = 0, lenr1 = 0;

        for (lenr0 = 1; lenr0 < lenT; lenr0++) {
            if (tot0 * lenr0 >= lenT) {
                break;
            }
            if ((lenT - tot0 * lenr0) % tot1 > 0) {
                continue;
            }
            lenr1 = (lenT - tot0 * lenr0) / tot1;
            boolean flag = true;
            int cnt0 = 0;
            int cnt1 = 0;
            long hashr0 = 0;
            long hashr1 = 0;

            for (int i = 1; i <= lenS; i++) {
                if (s.charAt(i) == '0') {
                    int l = cnt0 * lenr0 + cnt1 * lenr1 + 1;
                    int r = l + lenr0 - 1;
                    long currHash = hash(l, r);
                    if (hashr0 == 0) {
                        hashr0 = currHash;
                    } else {
                        if (currHash != hashr0) {
                            flag = false;
                            break;
                        }
                    }
                    cnt0++;
                } else if (s.charAt(i) == '1') {
                    int l = cnt0 * lenr0 + cnt1 * lenr1 + 1;
                    int r = l + lenr1 - 1;
                    long currHash = hash(l, r);
                    if (hashr1 == 0) {
                        hashr1 = currHash;
                    } else {
                        if (currHash != hashr1) {
                            flag = false;
                            break;
                        }
                    }
                    cnt1++;
                }
                if (hashr0 != 0 && hashr1 != 0 && hashr0 == hashr1) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    private static void calculateHash() {
        pre = new long[MAX];
        ppow = new long[MAX];
        pre[0] = 0;
        ppow[0] = 1;
        for (int i = 1; i <= lenT; i++) {
            pre[i] = (pre[i - 1] * seed + t.charAt(i) - 'a' + 1) % MOD;
            ppow[i] = ppow[i - 1] * seed % MOD;
        }
    }

    private static long hash(int l, int r) {
        return (pre[r] - pre[l - 1] * ppow[r - (l - 1)] + MOD * MOD) % MOD;
    }

}
