package hacker_rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularArrayRotation {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3};
        int k = 2;
        int[] queries = {0, 1, 2};

        System.out.println(Arrays.toString(circularArrayRotation(a1, k, queries)));
    }

    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        List<Integer> list = new ArrayList<>();
        for (int i : a) {
            list.add(i);
        }

        for (int i = 0; i < k; i++) {
            int last = list.remove(list.size() - 1);
            list.add(0, last);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = list.get(queries[i]);
        }

        return result;
    }
}
