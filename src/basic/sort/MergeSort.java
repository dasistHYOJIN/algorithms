package basic.sort;

import java.util.*;
import java.util.stream.Collectors;

/*
* 빠를수는 있겠지만 분할하는 만큼 List를 만들어야 하기 때문에
* 공간 복잡도 측면에서 O(n)이 된다
* 따라서 메모리가 부족한 상황에서는 적합하지 않을수도
* */

public class MergeSort implements Sort {

    @Override
    public List<Integer> sort(final int[] input) {
        // 분리하고
        List<List<Integer>> list = divide(Arrays.stream(input).boxed().collect(Collectors.toList()));

        // 비교해서 병합
        List<List<Integer>> result = new ArrayList<>();

        while (result.size() != 1) {
            result = new ArrayList<>();

            for (int i = 0; i < list.size(); i += 2) {
                result.add(merge(new LinkedList<>(list.get(i)), new LinkedList<>(list.get(i + 1))));
            }

            list.clear();
            list.addAll(result);
        }

        return result.get(0);
    }

    private List<Integer> merge(final List<Integer> l1, final List<Integer> l2) {
        List<Integer> list = new LinkedList<>();

        while (!(l1.isEmpty() || l2.isEmpty())) {
            if (l1.get(0) < l2.get(0)) {
                list.add(l1.remove(0));
            } else {
                list.add(l2.remove(0));
            }
        }

        list.addAll(!l1.isEmpty() ? l1 : l2);

        return list;
    }

    private List<List<Integer>> divide(final List<Integer> list) {
        if (list.size() == 1) {
            return Collections.singletonList(list);
        }

        List<Integer> l1 = list.subList(0, list.size() / 2);
        List<Integer> l2 = list.subList(list.size() / 2, list.size());

        List<List<Integer>> l = new ArrayList<>();
        l.addAll(divide(l1));
        l.addAll(divide(l2));

        return l;
    }
}
