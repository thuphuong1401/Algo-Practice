/*
You're developing a new programming language with some unusual features for strings! Among these is a method that returns the longest palindrome that can be formed with the characters of a given string.

Given a string s, your task is to find this longest possible palindrome. You may use any number of the characters from s, and arrange them in any order (so long as it results in a palindrome).

If there are multiple longest palindromes that can be formed, return the one among them that's lexicographically smallest.

Example

For s = "aaabb", the output should be maximalPalindrome(s) = "ababa".

There are two possible palindromes of length 5 that can be obtained ("ababa" and "baaab"), but "ababa" is lexicographically smaller, thus it is the answer.

For s = "aaabbbcc", the output should be maximalPalindrome(s) = "abcacba".

It's not possible to form a palindrome of length 8, but from several palindromes of length 7, "abcacba" is the lexicographically smallest, thus it is the answer.

Input/Output

[execution time limit] 3 seconds (java)

[input] string s

The given string.

Guaranteed constraints:
1 ≤ s.length ≤ 105.

[output] string

The lexicographically smallest palindrome with maximal length that can be built from the given string s.
*/


String maximalPalindrome(String s) {
    int[] count = new int[26];
    for(char c : s.toCharArray()) {
        count[c - 'a']++;
    }
    
    int n = s.length();
    Character[] palindrome = new Character[n];
    
    int ind = 0;
    for(int i = 0; i < 26; i++) {
        char curr = (char)('a' + i);
        if(count[i] >= 2) {
            int time = count[i] / 2;
            for(int j = 0; j < time; j++) {
                palindrome[ind] = curr;
                palindrome[n - 1 - ind] = curr;
                ind++;
            }
            count[i] -= (time * 2);
        }
    }
    
    int freqOne = 0;
    for(int i = 0; i < 26; i++) {
        if(count[i] == 1) {
            freqOne = i;
            break;
        }
    }
    
    
    char add = (char)('a' + freqOne);
    
    for(int i = 0; i < n; i++) {
        while(i < n && palindrome[i] == null && count[freqOne] != 0) {
            palindrome[i] = add;
            i++;
            count[freqOne]--;
        }
    }
    
    StringBuilder sb = new StringBuilder();
    for(Character c : palindrome) {
        if(c != null) {
            sb.append(c);
        }
    }
    
    return sb.toString();
}
