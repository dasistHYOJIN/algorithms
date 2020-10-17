package sort;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> shuffledList = IntStream.rangeClosed(1, 65536).boxed().collect(Collectors.toList());
        Collections.shuffle(shuffledList);

        long bubbleTime = doSort(new BubbleSort(), shuffledList);
        System.out.println(String.format("bubble basic.sort: %d", bubbleTime));

        long selectionTime = doSort(new SelectionSort(), shuffledList);
        System.out.println(String.format("selection basic.sort: %d", selectionTime));

        long insertionTime = doSort(new InsertionSort(), shuffledList);
        System.out.println(String.format("insertion basic.sort: %d", insertionTime));

        long mergeTime = doSort(new MergeSort(), shuffledList);
        System.out.println(String.format("merge basic.sort: %d", mergeTime));

        long shellTime = doSort(new ShellSort(), shuffledList);
        System.out.println(String.format("shell basic.sort: %d", shellTime));

        long quickTime = doSort(new QuickSort(), shuffledList);
        System.out.println(String.format("quick basic.sort: %d", quickTime));

    }

    private static long doSort(final Sort sort, final List<Integer> list) {
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();

        long startTime = System.currentTimeMillis();
        sort.sort(array);

        return System.currentTimeMillis() - startTime;
    }
}
