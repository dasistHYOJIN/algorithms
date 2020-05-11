package hacker_rank;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LilysHomework_3 {
    public static void main(String[] args) {
        int[] arr1 = {2, 5, 3, 1};
        System.out.println(lilysHomework(arr1));

        int[] arr2 = {3, 4, 2, 5, 1};
        System.out.println(lilysHomework(arr2));

        int[] arr3 = {1, 2, 4, 3, 5};
        System.out.println(lilysHomework(arr3));

        int[] arr4 = {5, 9, 3, 1, 2, 8};
        System.out.println(lilysHomework(arr4));

    }

    static int lilysHomework(int[] arr) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        int[] arr1 = arr.clone();

        Map<Integer, Integer> sortedMap = IntStream.range(0, sortedArr.length).boxed()
                .collect(Collectors.toMap((index) -> sortedArr[index], index -> index));
        int swap1 = compare(arr, sortedArr, sortedMap);

        sortedMap = IntStream.range(0, sortedArr.length).boxed()
                .collect(Collectors.toMap((index) -> sortedArr[index], index -> arr.length - index - 1));
        int swap2 = compare(arr1, sortedArr, sortedMap);

        System.out.println(swap1 + " " + swap2);

        return Math.min(swap1, swap2);
    }

    private static int compare(int[] arr, int[] sortedArr, Map<Integer, Integer> sortedMap) {
        int swap = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == sortedArr[i]) continue;

            int index = sortedMap.get(arr[i]);
            swap(arr, i, index);
            swap++;
        }
        return swap;
    }

    private static void swap(int[] arr, int p, int minIndex) {
        int temp = arr[p];
        arr[p] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
