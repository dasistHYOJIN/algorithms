package hacker_rank;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LilysHomework_2 {
    public static void main(String[] args) {
        int[] arr1 = {7, 15, 12, 3};
//        System.out.println(lilysHomework(arr1));

        int[] arr2 = {3, 4, 2, 5, 1};
        System.out.println(lilysHomework(arr2));

        int[] arr3 = {1, 2, 4, 3, 5};
        System.out.println(lilysHomework(arr3));

        int[] arr4 = {5, 9, 3, 1, 2, 8};
//        System.out.println(lilysHomework(arr4));

    }

    static int lilysHomework(int[] arr) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        Map<Integer, Integer> map = IntStream.range(0, arr.length).boxed()
                .collect(Collectors.toMap((index) -> arr[index], index -> index));
        Map<Integer, Integer> sortedMap = IntStream.range(0, sortedArr.length).boxed()
                .collect(Collectors.toMap((index) -> sortedArr[index], index -> index));

        int swap1 = compare(arr, map, sortedMap);

        map = IntStream.range(0, arr.length).boxed()
                .collect(Collectors.toMap((index) -> arr[index], index -> index));
        sortedMap = IntStream.range(0, sortedArr.length).boxed()
                .collect(Collectors.toMap((index) -> sortedArr[index], index -> arr.length - index - 1));

        System.out.println(Arrays.toString(arr));
        int swap2 = compare(arr, map, sortedMap);

        return Math.min(swap1, swap2);
    }

    private static int compare(int[] arr, Map<Integer, Integer> map, Map<Integer, Integer> sortedMap) {
        int swap = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (sortedMap.get(arr[i]).equals(map.get(arr[i]))) {
                System.out.println(map);
                continue;
            }

            System.out.println(map + " <- " + i);
//            System.out.println(String.format("%d:%d %d", arr[i], map.get(arr[i]), sortedMap.get(arr[i])));

            int index = sortedMap.get(arr[i]);
            map.put(arr[index], i);
            swap++;
        }
        return swap;
    }
}
