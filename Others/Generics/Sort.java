import java.util.*;

public class Main {

    public static void main(String[] args) {
        Integer ints[] = {10, 1, 2, 5, 3, 4, 6, 7, 8, 17, 9, 11, 13, 14, 12, 15, 16, 18, 20, 19};
        String[] strings = {"now", "is", "the", "time", "for", "all", "good", "folk", "to", "come", "to", "the", "aid", "of", "the", "party"};

        for(int i = 0; i < 20; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
        sort(ints, 20);
        for(int i = 0; i < 20; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
        sort(strings, 16);
        for(int i = 0; i < 16; i++) {
            System.out.print(strings[i] + " ");
        }
        System.out.println();
    }

    private static <T extends Comparable<T>> void sort(T A[], int A_size) {
        for(int i = 1; i < A_size; i++) {
            int j = i;
            T t = A[i];
            for(; j > 0; j--) {
                if(t.compareTo(A[j-1]) > 0) {
                    break;
                }
                A[j] = A[j-1];
            }
            A[j] = t;
        }
    }
}
