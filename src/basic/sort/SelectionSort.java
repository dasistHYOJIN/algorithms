package basic.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SelectionSort implements Sort {
    @Override
    public List<Integer> sort(final int[] input) {
        for (int baseIndex = 0; baseIndex < input.length; baseIndex++) {
            int minIndex = getMinIndex(input, baseIndex);
            swap(input, baseIndex, minIndex);
        }

        return Arrays.stream(input).boxed().collect(Collectors.toList());
    }

    private int getMinIndex(final int[] input, final int baseIndex) {
        int minIndex = baseIndex;

        for (int i = baseIndex; i < input.length; i++) {
            minIndex = (input[minIndex] > input[i]) ? i : minIndex;
        }

        return minIndex;
    }

    private void swap(final int[] input, final int baseIndex, final int maxIndex) {
        int temp = input[baseIndex];
        input[baseIndex] = input[maxIndex];
        input[maxIndex] = temp;
    }
}
