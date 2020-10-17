package hacker_rank;

import java.util.ArrayList;
import java.util.List;

public class AlmostSorted {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 3, 4, 2, 6, 7, 8, 9};
//        almostSorted(arr1);

        int[] arr2 = {1, 5, 4, 3, 2, 6};
//        almostSorted(arr2);

        int[] arr3 = {3, 1, 2};
        almostSorted(arr3);

        int[] arr4 = {4, 2};
//        almostSorted(arr4);

        int[] arr5 = {1, 2, 3, 5, 4, 6};
        almostSorted(arr5);
    }

    private static void almostSorted(int[] arr) {
        List<Decrescendo> decrescendos = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                Decrescendo decrescendo = findDecrescendo(i, arr);
                decrescendos.add(decrescendo);
                i = decrescendo.b;
            }
        }

        StringBuilder result = new StringBuilder();
        if (arr.length == 2) {
            result.append("yes\n").append("swap 1 2");
        } else if (decrescendos.size() == 1) {
            int a = decrescendos.get(0).a;
            int b = decrescendos.get(0).b;

            if ((0 < a && arr[a - 1] < arr[b] || a == 0) && arr[b] < arr[a] && (arr[a] < arr[b + 1] || b == arr.length - 1)) {
                result.append("yes\n")
                        .append((a + 1 == b) ? "swap " : "reverse ")
                        .append(String.format("%d %d", a + 1, b + 1));
            } else {
                result.append("no");
            }
        } else if (decrescendos.size() == 2) {
            int a = decrescendos.get(0).a;
            int b = decrescendos.get(1).b;

            if ((0 < a && arr[a - 1] < arr[b] || a == 0) && ((arr[a] < arr[b + 1]) || b == arr.length - 1)
                    && arr[b] < arr[a + 1] && arr[b - 1] < arr[a]) {
                result.append("yes\n").append(String.format("swap %d %d", a + 1, b + 1));
            } else {
                result.append("no");
            }
        } else {
            result.append("no");
        }

        System.out.println(result.toString());
    }

    private static Decrescendo findDecrescendo(int i, int[] arr) {
        Decrescendo decrescendo = new Decrescendo();
        decrescendo.a = i;

        while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
            i++;
        }
        decrescendo.b = i;

        return decrescendo;
    }

    private static class Decrescendo {
        int a;
        int b;
    }
}
