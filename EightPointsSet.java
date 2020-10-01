/*
https://codeforces.com/problemset/problem/334/B#:~:text=In%20other%20words%2C%20there%20must,a%20set%20of%20eight%20points.
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static void main(String[] args) {
    int max = (int)1e6 + 5;
    Scanner scan = new Scanner(System.in);
    ArrayList<Point> points = new ArrayList<>();
    boolean[] freq_x = new boolean[max];
    boolean[] freq_y = new boolean[max];
    ArrayList<Integer> unique_x = new ArrayList<>();
    ArrayList<Integer> unique_y = new ArrayList<>();
    
    for(int i = 0; i < 8; i++) {
      int x = scan.nextInt();
      int y = scan.nextInt();
      points.add(new Point(x, y));
    }
    
    for(int i = 0; i < 8; i++) {
      Point pt = points.get(i);
      
      if(!freq_x[pt.x]) {
        freq_x[pt.x] = true;
        unique_x.add(pt.x);
      }
      
      if(!freq_y[pt.y]) {
        freq_y[pt.y] = true;
        unique_y.add(pt.y);
      }
    }
    
    
    if(unique_x.size() != 3 || unique_y.size() != 3) {
      System.out.println("ugly");
      return;
    }
    
    // Generate all 8 points, then compare to the original points
    // ascending
    Collections.sort(unique_x);
    Collections.sort(unique_y);
    Collections.sort(points);
    
    int index = 0;
    
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        if(i == j && i == 1) { // mid point
          continue;
        }
        
        int x = points.get(index).x;
        int y = points.get(index).y;
        if (unique_x.get(i) == x && unique_y.get(j) == y) {
          index++;
        } else {
          System.out.println("ugly");
          return;
        }
      }
    }
    System.out.println("respectable");
  }
}
  
  class Point implements Comparable<Point> {
    Integer x;
    Integer y;
    
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
    
    @Override
    public int compareTo(Point p) {
      if(this.x.equals(p.x)) {
        return this.y.compareTo(p.y);
      }
      return this.x.compareTo(p.x);
    }
    
    public void printPoint() {
      System.out.println(this.x + " : " + this.y);
    }
  }
