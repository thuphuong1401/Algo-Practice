/*
Given a square matrix of integers m, your task is to rearrange its numbers in the following way:

First, sort its values in ascending order of how frequently the number occurs in m. In the case of a tie, sort the equally frequent numbers by their values, in ascending order.
Second, place the sorted numbers diagonally, starting from the bottom right corner, like this:
element ordering
Example

For

m = [[ 1, 4, -2],
     [-2, 3,  4],
     [ 3, 1,  3]]
the output should be

sortMatrixByOccurrences(m) = [[3,  3,  4],
                              [3,  4,  1],
                              [1, -2, -2]]
First we look at the frequency of each number:

Number 1 occurs 2 times;
Number -2 occurs 2 times;
Number 3 occurs 3 times;
Number 4 occurs 2 times.
Because numbers 1, -2, and 4 occur the same number of times, we sort them by their values in ascending order. Number 3 occurs the most numbers of times, so it goes after all other numbers. Finally, after sorting we get the following array: [-2, -2, 1, 1, 4, 4, 3, 3, 3]

After sorting, the numbers should be placed diagonally starting from the bottom right corner, as follows:

[[3,  3,  4],
 [3,  4,  1],
 [1, -2, -2]]
Input/Output

[execution time limit] 3 seconds (java)

[input] array.array.integer m

A square matrix of integers.

Guaranteed constraints:
1 ≤ m.length ≤ 40,
m[i].length = m.length,
-1000 ≤ m[i][j] ≤ 1000.

[output] array.array.integer

The matrix m rearranged according to the specifications above.
*/

int[][] sortMatrixByOccurrences(int[][] m) {
    int n = m.length;
    Map<Integer, Integer> freq = new HashMap<>();
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(!freq.containsKey(m[i][j])) {
                freq.put(m[i][j], 1);
            } else {
                freq.put(m[i][j], freq.get(m[i][j]) + 1);
            }
        }
    }
    
    
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> compare(a, b, freq));
    for(int num : freq.keySet()) {
        pq.add(num);
    }
    
    List<Integer> sorted = new ArrayList<>();
    while(!pq.isEmpty()) {
        int num = pq.remove();
        while(freq.get(num) != 0) {
            sorted.add(num);
            freq.put(num, freq.get(num) - 1);
        }
    }
    
    
    int row = n-1;
    int col = n-1;
    int ind = 0;
    
    int[][] res = new int[n][n];
    System.out.println(sorted);
    while(col >= 0) {
        int x = n-1;
        int y = col;
        while(x >= 0 && y < n && ind < sorted.size()) {
            res[x][y] = sorted.get(ind);        
            x--;
            y++;
            ind++;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        
        col--;
    }
    
    row = n;
    while(row >= 0) {
        int x = row-2;
        int y = 0;
        while(x >= 0 && y < n && ind < sorted.size()) {
            res[x][y] = sorted.get(ind);
            x--;
            y++;
            ind++;
        }
        row--;
    }
    
    return res;
}


private static int compare(int a, int b, Map<Integer, Integer> freq) {
    if(freq.get(a) < freq.get(b)) {
        return -1;
    } else if(freq.get(a) > freq.get(b)) {
        return 1;
    } else {
        if(a < b) {
            return -1; 
        } else if(a > b) {
            return 1;
        } else {
            return 0;
        }
    }
}
