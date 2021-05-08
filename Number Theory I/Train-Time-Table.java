/*
https://vn.spoj.com/problems/TTABLE/
*/

import java.util.*;

class Pair {
    Integer first;
    Integer second;

    public Pair(Integer f, Integer s) {
        first = f;
        second = s;
    }

}

class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int p = 0; p < T; ++p) {
            int n[] = new int[2];
            int result[] = new int[2];
            int turn_time = scan.nextInt();
            n[0] = scan.nextInt();
            n[1] = scan.nextInt();

            List<List<Pair>> trip = new ArrayList<>();

            for (int i = 0; i < 2; ++i) {
                trip.add(new ArrayList<Pair>());
            }

            String hour;
            String minute;
            StringBuilder token;
            int sep;
            for (int j = 0; j < 2; ++j) {
                for (int i = 0; i < n[j]; ++i) {
                    token = new StringBuilder(scan.next());
                    sep = token.indexOf(":");
                    hour = token.substring(0, sep);
                    minute = token.substring(sep + 1, token.length());
                    int start_time = Integer.parseInt(hour) * 60 + Integer.parseInt(minute);

                    token = new StringBuilder(scan.next());
                    sep = token.indexOf(":");
                    hour = token.substring(0, sep);
                    minute = token.substring(sep + 1, token.length());
                    int end_time = Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
                    end_time += turn_time;
                    trip.get(j).add(new Pair(start_time, end_time));
                }
            }

            result[0] = n[0];
            result[1] = n[1];
            for (int j = 0; j < 2; ++j) {
                int waiting = j, travelling = (j + 1) % 2;

                Collections.sort(trip.get(waiting), new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        return o1.first - o2.first;
                    }
                });

                Collections.sort(trip.get(travelling), new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        return o1.second - o2.second;
                    }
                });

                int i1 = 0, i2 = 0;
                while (i1 < n[waiting] && i2 < n[travelling]) {
                    if (trip.get(waiting).get(i1).first >= trip.get(travelling).get(i2).second) {
                        result[waiting]--;
                        i2++;
                    }
                    i1++;
                }
            }

            System.out.printf("Case #%d: %d %d\n", p + 1, result[0], result[1]);
        }
        scan.close();
    }
}
