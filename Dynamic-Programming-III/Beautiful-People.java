/*
https://codeforces.com/problemsets/acmsguru/problem/99999/199
*/
import java.io.*;
import java.util.*;

class Member implements Comparable<Member> {

  int id;
  long si;
  long bi;

  public Member(int id, long si, long bi) {
    this.id = id;
    this.si = si;
    this.bi = bi;
  }

  @Override
  public int compareTo(Member other) {
    if (this.si != other.si) {
      if (this.si - other.si < 0) {
        return -1;
      } else if (this.si - other.si > 0) {
        return 1;
      } else {
        return 0;
      }
    } else {
      if (this.bi - other.bi < 0) {
        return 1;
      } else if (this.bi - other.bi > 0) {
        return -1;
      } else {
        return 0;
      }
    }
  }

  @Override
  public String toString() {
    return this.si + " " + this.bi;
  }
}

class MyCode {

  static int n;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    Member[] mem = new Member[n];
    for (int i = 0; i < n; i++) {
      long si = scan.nextLong();
      long bi = scan.nextLong();
      mem[i] = new Member(i + 1, si, bi);
    }
    Arrays.sort(mem);
    LIS(mem);
  }

  private static void LIS(Member[] mem) {
    int length = 1;
    List<Integer> result = new ArrayList<>();
    result.add(0);
    int[] path = new int[n];
    Arrays.fill(path, -1);
    for (int i = 1; i < n; i++) {
      if (mem[i].bi <= mem[result.get(0)].bi) {
        result.set(0, i);
      } else if (mem[i].bi > mem[result.get(length - 1)].bi) {
        path[i] = result.get(length - 1);
        result.add(i);
        length++;
      } else {
        int pos = lowerBound(mem, result, length, mem[i]);
        path[i] = result.get(pos - 1);
        result.set(pos, i);
      }
    }

    System.out.println(length);
    printLIS(mem, path, result.get(length - 1));
  }

  private static void printLIS(Member[] mem, int[] path, int last) {
    int i = last;
    List<Member> b = new ArrayList<>();
    while (i >= 0) {
      b.add(mem[i]);
      i = path[i];
    }

    for (int j = b.size() - 1; j >= 0; j--) {
      System.out.print(b.get(j).id + " ");
    }
  }

  private static int lowerBound(
    Member[] mem,
    List<Integer> result,
    int n,
    Member x
  ) {
    int left = 0;
    int right = n;
    int pos = n;
    while (left < right) {
      int mid = left + (right - left) / 2;
      int index = result.get(mid);
      if (mem[index].bi >= x.bi) {
        pos = mid;
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return pos;
  }
}
