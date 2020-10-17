package programmers;

import java.util.LinkedList;
import java.util.List;

public class SolutionTest {
    public static void main(String[] args) {
        SolutionTest solution = new SolutionTest();

        int[][] v = {{1, 4}, {3, 4}, {3, 10}};
        solution.solution(v);
    }

    public int[] solution(int[][] v) {
        int x = getIntegers(v, 0);
        int y = getIntegers(v, 1);

        return new int[]{x, y};
    }

    private int getIntegers(final int[][] v, final int i) {
        List<Integer> x = new LinkedList<>();

        for (int[] value : v) {
            if (x.contains(value[i])) {
                x.remove((Integer) value[i]);
            } else {
                x.add(value[i]);
            }
        }

        return x.get(0);
    }
}
