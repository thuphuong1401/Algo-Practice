/*
Reverse every word in a sentence (in place, take into account multiple spaces between words
*/
import java.util.*;
import java.io.*;

class MyCode {
	
    public static void main (String[] args) {
        String s = "My    name is  Phuong";
        char[] sCharArray = s.toCharArray();
        int len = sCharArray.length;
        int pt1 = 0;
        
        while(pt1 < len) {
            if(sCharArray[pt1] == ' ') {
                pt1++;
                continue;
            }
            int pt2 = pt1;
            while(pt2 < len && sCharArray[pt2] != ' ') {
                pt2++;
            }
            sCharArray = reverse(sCharArray, pt1, pt2);
            pt1 = pt2;
        }
        
        System.out.println(String.valueOf(sCharArray));
    }
    
    private static char[] reverse(char[] sCharArray, int pt1, int pt2) {
        
        int wordLength = pt2 - pt1;
        for(int i = 0; i < wordLength/2; i++) {
            char temp = sCharArray[pt1 + i];
            sCharArray[pt1 + i] = sCharArray[pt2 - 1 - i];
            sCharArray[pt2 - 1 - i] = temp;
        }
        return sCharArray;
    }
    
}
