/*
https://codeforces.com/problemset/problem/691/A
*/

import java.util.Scanner;
import java.util.ArrayList;

public class fashionInBerland {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<String>();
        while (scan.hasNextLine()) {
            String read = scan.nextLine();
            if (read == null || read.isEmpty()) {
                break;
            }
            input.add(read);
        }

        // Cases:
        if (Integer.parseInt(input.get(0)) == 1) {
            if (Integer.parseInt(input.get(1)) == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            if (containsOnlyOneZero(input.get(1)) == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean containsOnlyOneZero(String s) {
        int countZero = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.getNumericValue(c) == 0) {
                countZero++;
            }
        }

        if (countZero == 1) {
            return true;
        }
        return false;
    }

}
