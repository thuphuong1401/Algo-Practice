/*
https://vn.spoj.com/problems/SOCIALNE.pdf
*/
import java.util.*;
import java.io.*;

class MyCode {
    public static final int INF = (int) 1e9;
    static int[][] dist;
    static int V;
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        
        for(int i = 0; i < numTestCases; i++) {
            
            String s = scan.next();
            V = s.length();
            dist = new int[V][V];
            
            for (int j = 0; j < V; j++) {
                if (j != 0) {
                    s = scan.next();
                }
                for(int k = 0; k < V; k++) {
                    if(s.charAt(k) == 'Y') {
                        dist[j][k] = 1;
                    } else {
                        if(j == k) {
                            dist[j][k] = 0;
                        } else {
                            dist[j][k] = INF;
                        }
                    }
                }
            }
            
            FloydWarshall();
            
            int maxCount = 0;
            int bro = 0;
            for(int j = 0; j < V; j++) {
                int count = 0;
                for(int k = 0; k < V; k++) {
                    
                    if(dist[j][k] == 2) {
                        count++;                        
                    }
                }
                
                if(count > maxCount) {
                    maxCount = count;
                    bro = j;
                }
            }
            
            System.out.println(bro + " " + maxCount);
            
        }
	}

    
    public static void FloydWarshall() {
        for(int k = 0; k < V; k++) {
            for(int i = 0; i < V; i++) {
                for(int j = 0; j < V; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
    
}



/*
A - B - C
 \  D  /

== 2
>= 2 ~  it nhat 1 ban chung
> 2  ~ 2 ban chung
*/
