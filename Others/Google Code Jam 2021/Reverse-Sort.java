
/*
First problem of Qualification Round
*/
import java.util.*;
import java.io.*;

class MyCode {

	static int n;
	static int[] arr;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numTestCases = scan.nextInt();
		for (int i = 0; i < numTestCases; i++) {
			n = scan.nextInt();
			arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = scan.nextInt();
			}
			int ans = reverseSortCost();
			System.out.println("Case #" + (i + 1) + ": " + ans);
		}
	}

	private static int posMinVal(int index) {
		int posMin = index;
		int min = arr[index];
		for (int i = index; i < n; i++) {
			int curr = arr[i];
			if (curr < min) {
				min = curr;
				posMin = i;
			}
		}
		return posMin;
	}

	private static void reverse(int start, int end) {
		int l = end - start + 1;
		int[] temp = new int[l];
		int ind = 0;
		for (int i = start; i <= end; i++) {
			temp[ind] = arr[i];
			ind++;
		}
		ind = l - 1;
		for (int i = start; i <= end; i++) {
			arr[i] = temp[l - 1];
			l--;
		}
	}

	private static int reverseSortCost() {
		int cost = 0;
		for (int i = 0; i < n - 1; i++) {
			int j = posMinVal(i);
			reverse(i, j);
			cost += (j - i + 1);
		}
		return cost;
	}

}
