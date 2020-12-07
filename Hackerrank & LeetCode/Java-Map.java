//Complete this code or write your own from scratch
/*
https://www.hackerrank.com/challenges/phone-book/problem
*/
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        int n = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < n; i++) {
            String s = scan.nextLine();
            String l = scan.nextLine();
            map.put(s, l);    
        }
        while(scan.hasNext()) {
            String query = scan.nextLine().trim();
            if(map.containsKey(query)) {
                System.out.println(query + "=" + map.get(query));
            } else {
                System.out.println("Not found");
            }
        }   
    }
}


