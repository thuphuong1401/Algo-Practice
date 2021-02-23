/*
https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1186
*/
import java.util.*;
import java.io.*;

class Point {
    public Double x, y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}


class MyCode {
    private static final int INF = (int) 1e9;
    
    private static double distance(Point p1, Point p2) {
        double x = p1.x - p2.x;
        double y = p1.y - p2.y;
        return Math.sqrt(x*x + y*y);
    }
    
    private static double bruteForce(List<Point> points, int left, int right) {
        double min_dist = INF;
        for(int i = left; i < right; i++) {
            for(int j = i+1; j < right; j++) {
                min_dist = Math.min(min_dist, distance(points.get(i), points.get(j)));
            }
        }
        return min_dist;
    }
    
    
    static double stripClosest(List<Point> point_set, int left, int right, int mid, double dist_min) {
        Point point_mid = point_set.get(mid);
        List<Point> splitted_points = new ArrayList<>();
        for(int i = left; i < right; i++) {
            if(Math.abs(point_set.get(i).x - point_mid.x) <= dist_min) {
                splitted_points.add(point_set.get(i));
            }
        }
        Collections.sort(splitted_points, (o1, o2) -> Double.compare(o1.y, o2.y));
        double smallest = INF;
        int l = splitted_points.size();
        for(int i = 0; i < l; i++) {
            for(int j = i+1; j < l && splitted_points.get(j).y - splitted_points.get(i).y < dist_min; j++) {
                double d = distance(splitted_points.get(i), splitted_points.get(j));
                smallest = Math.min(smallest, d);
            }
        }
        return smallest;
    }
    
    
    static double minimalDistance(List<Point> point_set, int left, int right) {
        if(right - left <= 3) {
            return bruteForce(point_set, left, right);
        }
        int mid = (left + right) / 2;
        double dist_left = minimalDistance(point_set, left, mid);
        double dist_right = minimalDistance(point_set, mid+1, right);
        double dist_min = Math.min(dist_left, dist_right);
        return Math.min(dist_min, stripClosest(point_set, left, right, mid, dist_min));
    }
    
	public static void main (String[] args) {        
        Scanner scan = new Scanner(System.in);
        while(true) {
            int n = scan.nextInt();
            if(n == 0) {
                return;
            }
            List<Point> point_set = new ArrayList<Point>();
            for(int i = 0; i < n; i++) {
                double x = scan.nextDouble();
                double y = scan.nextDouble();
                point_set.add(new Point(x, y));
            }
            Collections.sort(point_set, (p1, p2) -> p1.x.compareTo(p2.x));
            double ans = minimalDistance(point_set, 0, n);
            if(ans < 10000) {
                System.out.printf("%.4f", ans);
                System.out.println();
            } else {
                System.out.println("INFINITY");
            }
        }
	}
    
    
}


