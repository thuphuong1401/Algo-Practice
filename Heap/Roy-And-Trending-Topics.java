/*
https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/practice-problems/algorithm/roy-and-trending-topics-1/
*/

import java.io.*;
import java.util.*;

class Topic {
  public long id;
  public long newZScore;
  public long changeInZScore;
  public Topic(long id, long newZScore, long changeInZScore) {
    this.id = id;
    this.newZScore = newZScore;
    this.changeInZScore = changeInZScore;
  }
}

/*
Tips on how to write the compare method
Return values: -1 means t1 < t2, 0 means t1 = t2, 1 means t1 > t2
1. Write the "correct" way of how t1 should be compared to t2
2. Modify return result depending on the data structure consider (in this case, it's a min heap, that's why we have to flip order if we want to poll the maximum element
*/

class TopicComparator implements Comparator<Topic> {
  @Override
  public int compare(Topic t1, Topic t2) {
    if(t1.changeInZScore > t2.changeInZScore || (t1.changeInZScore == t2.changeInZScore && t1.id > t2.id)) {
      return -1;
    } else {
      return 1;
    }
  }
}

class MyCode {  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    PriorityQueue<Topic> pq = new PriorityQueue<>(new TopicComparator());
    for(int i = 0; i < n; i++) {
      long id = scan.nextLong();
      long Z = scan.nextLong();
      long P = scan.nextLong();
      long L = scan.nextLong();
      long C = scan.nextLong();
      long S = scan.nextLong();
      long newZ = (P*50) + (L*5) + (C*10) + (S*20);
      long change = newZ - Z;
      Topic t = new Topic(id, newZ, change);
      pq.add(t);
    }
    
    for(int i = 0; i < 5; i++) {
      Topic temp = pq.remove();
      System.out.println(temp.id + " " + temp.newZScore);
    }
  }
}

