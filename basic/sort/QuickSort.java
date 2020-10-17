package sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort implements Sort {
    @Override
    public List<Integer> sort(final int[] input) {
        List<Integer> list = Arrays.stream(input).boxed().collect(Collectors.toList());

        return doInnerSort(list);
    }

    private List<Integer> doInnerSort(final List<Integer> list) {
        if (list.size() == 1) {
            return list;
        }

        // 피벗을 나누고
        int pivot = getPivot(list);

        LinkedList<Integer> l = new LinkedList<>();
        l.add(pivot);

        // 왼쪽에 작은애 오른쪽
        for (int i = 0; i < list.size(); i++) {
            if (pivot > list.get(i)) {
                l.addFirst(list.get(i));
            } else {
                l.addLast(list.get(i));
            }
        }

        return l;
    }

    private int getPivot(final List<Integer> list) {
        return list.get(0);
    }
}
