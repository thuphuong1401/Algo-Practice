/*
https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=1099
*/

import java.util.*;
import java.io.*;

class MyCode {
    private static int[] parents;
    private static int[] size;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        makeSet();
        while(true) {
            int x, y, z;
            x = scan.nextInt();
            y = scan.nextInt();
            z = scan.nextInt();
            if(x == y && y == z && z == 0) {
                return;
            } 
            if(x == 1) { // setFriends
                if(!isEnemies(y, z)) {
                    setFriends(y, z); 
                } else {
                    System.out.println(-1);
                }
            } else if(x == 2) { // setEnemies
                if(!isFriends(y, z)) {
                    setEnemies(y, z);
                } else {
                    System.out.println(-1);
                }
            } else if(x == 3) { // areFriends
                System.out.println(isFriends(y, z) == true? "1" : "0");
            } else { // areEnemies
                System.out.println(isEnemies(y, z) == true? "1" : "0");
            }
        }
	}
    
    public static void makeSet() {
        parents = new int[20001];
        size = new int[20001];
        for(int i = 0; i < 20001; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }
    
    public static int find(int p) {
        int root = p;
        while(root != parents[root]) {
            root = parents[root];
        }    
        while(p != root) {
            int newp = parents[p];
            parents[p] = root;
            p = newp;
        }
        return root;
    }
    
    
    public static void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) {
            return;
        }
        
        if(size[rootP] > size[rootQ]) {
            parents[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
    }
    
    
    public static void setFriends(int p, int q) {
        union(p, q);
        union(10000 + p, 10000 + q);    
    }
    
    public static void setEnemies(int p, int q) {
        union(p, 10000 + q);
        union(10000 + p, q);
    }
    
    public static boolean isSameGroup(int p, int q) {
        
        // p and q in the same group
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
        
    }
    
    
    public static boolean isFriends(int p, int q) {
        boolean isFriend = isSameGroup(p, q);
        boolean hasSameEnemies = isSameGroup(10000 + p, 10000 + q);
        return isFriend || hasSameEnemies;
    }
    
    
    public static boolean isEnemies(int p, int q) {
        boolean isEnemy1 = isSameGroup(p, 10000 + q);
        boolean isEnemy2 = isSameGroup(10000 + p, q);
        return isEnemy1 || isEnemy2;    
    }
    
    
}


/*

1000 slots Friends | 1000 slots Enimies
0 ... 999 | 1000 ... 1999


1     | 1001
2     | 1002

p + 1000: xem p là kẻ thù
unionEnimies(2, 1003) => tất cả bạn bè của 2 xem 3 là kẻ thù



setFriends(1, 2)
- union(1, 2) => a ~ b v b ~ c => a ~ c
- union(1001, 1002) => If xx ∼ yy and yy ∗ zz then xx ∗ zz (An enemy of a friend is an enemy).

isFriends(1, 2)
- sameGroup(1, 2)
- sameGroup(1001, 1002) // 1 and 2 having same enemy (1001 and 1002 in the same group?)

setEnemies(2, 3)
- union(2, 1003) 
- union(3, 1002) 

isEnemies(2, 3)
- sameGroup(2, 1003) 
- sameGroup(3, 1002)

*/
 
