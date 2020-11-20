/*
https://www.programmersought.com/article/18781927992/
*/

import java.io.*;
import java.util.*;

class MyCode {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        for (int i = 0; i < numTestCases; i++) {
            int numContracts = scan.nextInt();
            PriorityQueue<Contract> pq = new PriorityQueue<>(new Comparator<Contract>() {
                @Override
                public int compare(Contract c1, Contract c2) {
                    return c2.ai - c1.ai;
                }
            });
            int max = 1000005;
            Contract[] contract = new Contract[max];
            for (int j = 0; j < numContracts; j++) {
                contract[j] = new Contract();
                contract[j].ai = scan.nextInt();
                contract[j].bi = scan.nextInt();
                contract[j].di = scan.nextInt();
            }
            Arrays.sort(contract, 0, numContracts);
            int time = 0;
            double minSum = 0;
            for (int j = 0; j < numContracts; j++) {
                time += contract[j].bi;
                pq.add(contract[j]);
                while (time > contract[j].di) {
                    Contract top = pq.poll();
                    if (top.bi > time - contract[j].di) {
                        minSum += (time - contract[j].di) * 1.0 / top.ai;
                        top.bi -= time - contract[j].di;
                        pq.add(top);
                        time = contract[j].di;
                    } else {
                        minSum += top.bi * 1.0 / top.ai;
                        time -= top.bi;
                        top.bi = 0;
                    }
                }
            }
            System.out.printf("%.2f\n", minSum);

        }
    }
}

class Contract implements Comparable<Contract> {
    public int ai;
    public int bi;
    public int di;

    public int compareTo(Contract c) {
        return this.di - c.di;
    }

    public Contract() {
        ai = 0;
        bi = 0;
        di = 0;
    }

}
