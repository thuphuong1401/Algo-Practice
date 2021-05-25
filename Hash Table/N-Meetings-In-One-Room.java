/*
https://www.geeksforgeeks.org/find-maximum-meetings-in-one-room/
Key idea: use greedy algorithm, sort the meetings in increasing order of finish time
*/
import java.util.*;
import java.io.*;

class Room implements Comparable<Room> {
    int start;
    int finish;
    int id;

    public Room(int start, int finish, int id) {
        this.start = start;
        this.finish = finish;
        this.id = id;
    }

    @Override
    public int compareTo(Room other) {
        if (this.finish < other.finish) {
            return -1;
        } else if (this.finish > other.finish) {
            return 1;
        } else {
            return 0;
        }
    }
}

class MyCode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int[] s = new int[n];
            int[] f = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = scan.nextInt();
            }
            for (int i = 0; i < n; i++) {
                f[i] = scan.nextInt();
            }
            Room[] rooms = new Room[n];
            for (int i = 0; i < n; i++) {
                rooms[i] = new Room(s[i], f[i], (i + 1));
            }

            Arrays.sort(rooms);

            List<Integer> ans = new ArrayList<>();
            ans.add(rooms[0].id);
            Room prev = rooms[0];
            for (int i = 1; i < n; i++) {
                if (rooms[i].start > prev.finish) {
                    ans.add(rooms[i].id);
                    prev = rooms[i];
                }
            }

            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
