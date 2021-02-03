/*
Given an array A. Is there any subset of array A in which if we do AND of all the elements 
of that subset then output should be in power of two (for eg, 2, 4, 8, 16, 32, etc)?

Input 
First line contains number of test cases T. Each test first line contains N size of array A
and next line contains N space separated integers.

Constraints:
- 1 <= T <= 1000
- 1 <= N <= 200
- 0 <= A_i <= 10^9

Output
For each test case print "YES" if there is any subset of array A in which if we do AND of all 
elements of that subset then output should be in power of 2. Else print "NO"

Example:
2
3
1 2 3
2
10 20

YES
NO


Explanation: 
- Vì constraint là power of 2 trong giới hạn integer => limit là 2^31. Vì vậy ta có thể check  
đến 2^30
- Subset không cần contiguous
- Power of 2 có duy nhất 1 bit = 1, còn lại đâu tất cả bằng 0
=> Big idea: 
    + Loop qua tất cả các số mũ 0 -> 31
    + Nếu AND của subset tốt nhất là power of 2, return true. Else return false
Để tìm subset tốt nhất AND ra power of 2 (2^k): cần tìm tất cả các số mà bit thứ k = 1 (để AND
với nhau thì bit thứ k đó không bị triệt tiêu đi)). Đồng thời phải đảm bảo kết quả AND != 0.
 

*/
import java.util.*;
import java.io.*;

class MyCode {
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        List<Integer> nums = new ArrayList<>();
        while(numTestCases > 0) {
            
            int n = scan.nextInt();
            for(int i = 0; i < n; i++) {
                nums.add(scan.nextInt());
            }
            
            if(checkSubset(nums)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            
            numTestCases--;
            nums.clear();
        }
        
	}
    
    public static boolean checkSubset(List<Integer> nums) {
        for(int i = 0; i < 31; i++) {
            int curr = 1 << i;
            int res = Integer.MAX_VALUE; // all 1 bit
            for(int j = 0; j < nums.size(); j++) {
                if((nums.get(j) & curr) != 0) { // nums[j] có kth bit = 1 hay không?
                    res &= nums.get(j); // nếu có, AND vào kq
                }
            }
            
            /*if(isPowerOfTwo(res)) { // subset tốt nhất có phải power of 2 hay không
                return true; // res == curr at this point
            }*/
            
            if(res == curr) {
                return true;
            }
        }
        return false;
    }
    
    
    /*public static boolean isPowerOfTwo(int n) {
        return (n & (n-1)) == 0; // x-1: turn off the righmost 1 bit of x 
    }*/
}







// Second method
class MyCode {
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        List<Integer> nums = new ArrayList<>();
        while(numTestCases > 0) {
            
            int n = scan.nextInt();
            for(int i = 0; i < n; i++) {
                nums.add(scan.nextInt());
            }
            
            if(checkSubset(nums)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            
            numTestCases--;
            nums.clear();
        }
        
	}
    
    public static boolean checkSubset(List<Integer> nums) {
        for(int i = 0; i < 31; i++) {
            int curr = 1 << i;
            int res = Integer.MAX_VALUE; // all 1 bit
            for(int j = 0; j < nums.size(); j++) {
                if((nums.get(j) & curr) != 0) { // nums[j] có kth bit = 1 hay không?
                    res &= nums.get(j); // nếu có, AND vào kq
                }
            }
            
            if(isPowerOfTwo(res)) { // subset tốt nhất có phải power of 2 hay không
                return true; // res == curr at this point
            }
        }
        return false;
    }
    
    
    public static boolean isPowerOfTwo(int n) {
        return (n & (n-1)) == 0; // x-1: turn off the righmost 1 bit of x 
    }
}
