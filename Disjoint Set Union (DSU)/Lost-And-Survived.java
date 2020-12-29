/*
https://www.spoj.com/problems/LOSTNSURVIVED/cstart=10
*/
import java.util.*;
import java.io.*;


class Tuple {
    public Integer numPeople;
    public Integer index;
    
    public Tuple(Integer numPeople, Integer index) {
        this.numPeople = numPeople;
        this.index = index;
    }
}

class MinHeapComparator implements Comparator<Tuple> {
    @Override
    public int compare(Tuple t1, Tuple t2) {
        return t1.numPeople.compareTo(t2.numPeople);
    }
}

class MyCode {

    private static int[] parent;
    private static int[] size;
    private static int count;
    private static int n, q;
    private static int max = 1;
    private static int min = Integer.MAX_VALUE;
    // minHeap
    private static PriorityQueue<Tuple> minHeap;
    
    
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        q = scan.nextInt();
        makeSet();
        for(int i = 0; i < q; i++) {
            int a = scan.nextInt() - 1;
            int b = scan.nextInt() - 1;
            union(a, b);
            Tuple firstTuple = minHeap.peek();
            while (firstTuple.index != parent[firstTuple.index] || size[firstTuple.index] != firstTuple.numPeople) { // check whether firstTuple.id has been merged
                minHeap.remove();
                firstTuple = minHeap.peek();
            }
            
            //System.out.println(firstTuple.index + " " + size[firstTuple.index] );
            int min = firstTuple.numPeople;
            int diff = max - min;
            System.out.println(diff);
            
        }
        
	}
    
    public static void makeSet() {
        count = n;
        parent = new int[n];
        size = new int[n];
        minHeap = new PriorityQueue<>(new MinHeapComparator());
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            minHeap.add(new Tuple(1, i));
        }
        
        
    }

    public static int find(int p) {
        int root = p;
        while (root != parent[root]) {
            root = parent[root];
        }
        while (p != root) {
            int newp = parent[p];
            parent[p] = root;
            p = newp;
        }
        return root;
    }


    public static void union(int p, int q) {
        
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
            max = Math.max(max, size[rootP]);
            minHeap.add(new Tuple(size[rootP], rootP));
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
            max = Math.max(max, size[rootQ]);
            minHeap.add(new Tuple(size[rootQ], rootQ));
        }
        count--;
        
    }
    
}



