import java.util.*;
import java.io.*;

class Point {
    Integer x;
    Integer y;
    
    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
}

class MyCode {
    private static int[] prefix;
	  private static int n;
    private static final int INF = (int)1e9;
    
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i]  = scan.nextInt();
        } 
        
        prefix = new int[n];
        prefix[0] = arr[0];
        for(int i = 1; i < n; i++) {
            prefix[i] += (prefix[i-1] + arr[i]);
        }
        long ans = minf(0, n-1);
        System.out.println(ans);
	}
    
    private static long f(Point p1, Point p2) {
        long first = p1.x - p2.x;
        long second = p1.y - p2.y;
        return (first*first) + (second*second);
    }

    private static long minf(int leftIdx, int rightIdx) {
        if(rightIdx - leftIdx <= 3) {
            return bruteForce(leftIdx, rightIdx);
        }
        int mid = (leftIdx + rightIdx)/2;
        long distLeft = minf(leftIdx, mid);
        long distRight = minf(mid+1, rightIdx);
        long distMin = Math.min(distLeft, distRight);
        long distMid = midStrip(distMin, mid, leftIdx, rightIdx);
        return Math.min(distMin, distMid);
    }
    
    
    private static long midStrip(long distMin, int midIdx, int leftIdx, int rightIdx) {
        // Mid point: (mid, prefix[mid])
        List<Point> splittedPoints = new ArrayList<>();
        // Collect cac diem nam trong khoang cach distMin tinh tu hoanh do cua diem midIdx
        for(int i = leftIdx; i <= rightIdx; i++) {
            if((i - midIdx) * (i - midIdx) <= distMin) {
                splittedPoints.add(new Point(i, prefix[i]));
            }
        }
        Collections.sort(splittedPoints, (o1, o2) -> Double.compare(o1.y, o2.y));
        long smallest = INF;
        int l = splittedPoints.size();
        for(int i = 0; i < l; i++) {
            for(int j = i+1; j < l && (splittedPoints.get(j).y - splittedPoints.get(i).y)*(splittedPoints.get(j).y - splittedPoints.get(i).y) < distMin; j++) {
                long d = f(splittedPoints.get(i), splittedPoints.get(j));
                smallest = Math.min(smallest, d);
            }
        }
        return smallest;
    }
    
    
    private static long bruteForce(int left, int right) {
        long min = INF;
        for(int i = left; i <= right; i++) {
            for(int j = i+1; j <= right; j++) {
                min = Math.min(min, f(new Point(i, prefix[i]), new Point(j, prefix[j])));
            }
        }
        return min;
    }    

}
