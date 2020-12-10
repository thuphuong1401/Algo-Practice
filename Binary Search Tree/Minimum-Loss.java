/*
https://www.hackerrank.com/challenges/minimum-loss/problem
*/

import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      TreeSet<Long> treeSet = new TreeSet<>();
      int n = scan.nextInt();
      long minLoss = Long.MAX_VALUE;

      for (int i = 0; i < n; i++) {
         Long sellPrice = scan.nextLong();
         if (!treeSet.isEmpty() && treeSet.last() > sellPrice) {
            long loss = treeSet.higher(sellPrice) - sellPrice;
            if (loss < minLoss) {
               minLoss = loss;
            }
         }
         treeSet.add(sellPrice);
      }

      System.out.print(minLoss);
   }
}
