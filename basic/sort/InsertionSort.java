package sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InsertionSort implements Sort {
    @Override
    public List<Integer> sort(final int[] input) {
        for (int targetIndex = 1; targetIndex < input.length; targetIndex++) {
            doInnerSort(input, targetIndex);
        }

        return Arrays.stream(input).boxed().collect(Collectors.toList());
    }

    private void doInnerSort(final int[] input, int targetIndex) {
        int key = input[targetIndex];
        for (int index = targetIndex - 1; index >= 0 && input[index] > key; index--) {
            swap(input, targetIndex, index);
            targetIndex = index;
        }
    }

    private void swap(final int[] input, final int i1, final int i2) {
        int temp = input[i1];
        input[i1] = input[i2];
        input[i2] = temp;
    }
}
