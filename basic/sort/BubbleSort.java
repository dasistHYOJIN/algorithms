package sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
* 최악과 최선 모두 O(n^2)
* 즉, 모든 경우에서 다 위의 시간복잡도를 갖기 때문에 웬만하면 지양하는 게 좋지 않을까?
* */

public class BubbleSort implements Sort {
    @Override
    public List<Integer> sort(final int[] input) {
        for (int baseIndex = 0; baseIndex < input.length - 1; baseIndex++) {
            doInnerSort(input, baseIndex);
        }

        return Arrays.stream(input).boxed().collect(Collectors.toList());
    }

    private void doInnerSort(final int[] input, final int baseIndex) {
        for (int i = baseIndex; i < input.length - 1; i++) {
            if (input[i] > input[i + 1]) {
                swap(input, i, i + 1);
            }
        }
    }

    private void swap(final int[] input, final int i1, final int i2) {
        int temp = input[i1];
        input[i1] = input[i2];
        input[i2] = temp;
    }
}
