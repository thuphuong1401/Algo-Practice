/*
https://codeforces.com/problemset/problem/886/C
*/

/*
Min number of rooms = tổng số lượng các phút không được ghi nhận tính từ phút thứ 0 đến phút thứ n-1 và cộng thêm 1 (tại luôn có ít nhất 1 phòng)
*/
import java.util.*;
import java.io.*;

class MyCode {
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        boolean[] visited  = new boolean[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        for(int ele : arr) {
            visited[ele] = true;
        }
        int minRoom = 1;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                minRoom++;
            }
        }
        System.out.println(minRoom);
	}
}



