/*
https://www.geeksforgeeks.org/find-character-first-string-present-minimum-index-second-string/
*/
import java.util.*;
import java.io.*;

class MyCode {

    static int MAX = (int) 1e6;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        for (int j = 0; j < n; j++) {
            String str = scan.nextLine();
            String patt = scan.nextLine();
            Map<Character, Integer> firstAppear = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!firstAppear.containsKey(c)) {
                    firstAppear.put(c, i);
                }
            }
            int minIndex = MAX;
            for (char c : patt.toCharArray()) {
                minIndex = Math.min(minIndex, firstAppear.getOrDefault(c, minIndex));
            }
            if (minIndex != MAX) {
                System.out.println(str.charAt(minIndex));
            } else {
                System.out.println("No character present");
            }
        }
    }
}
