/*
https://acm.timus.ru/problem.aspx?space=1&num=1585
*/
import java.io.*;
import java.util.*;

class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> treeMap = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            String peng = scan.nextLine();
            if(treeMap.containsKey(peng)) {
                treeMap.put(peng, treeMap.get(peng) + 1);
            } else {
                treeMap.put(peng, 1);
            }
        }
        int maxFreq = 0;
        String answer = "";
        for(Map.Entry<String, Integer> kvp : treeMap.entrySet()) {
            int currFreq = kvp.getValue();
            if(currFreq > maxFreq) {
                maxFreq = currFreq;
                answer = kvp.getKey();
            }
        }
        System.out.println(answer);
	}
}

