import java.util.*;

// brute force way, got time limit exceeded, but correct nevertheless

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int X = scan.nextInt();
        int Y = scan.nextInt();
        int[] soldier = new int[N];
        int[] vest = new int[M];
        boolean[] used = new boolean[M];
        HashMap<Integer, Integer> output = new HashMap<Integer, Integer>();

        for (int i = 0; i < N; i++) {
            soldier[i] = scan.nextInt();
        }

        for (int i = 0; i < M; i++) {
            vest[i] = scan.nextInt();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (vest[j] >= soldier[i] - X && vest[j] <= soldier[i] + Y && used[j] == false) {
                    output.put(i + 1, j + 1);
                    used[j] = true;
                    break;
                }
            }
        }

        System.out.println(output.size());
        Iterator it = output.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry mapElement = (Map.Entry) it.next();
            System.out.println(mapElement.getKey() + " " + mapElement.getValue());
        }

    }
}
