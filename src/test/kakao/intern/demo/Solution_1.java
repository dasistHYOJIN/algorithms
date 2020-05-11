package test.kakao.intern.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_1 {
    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();

        int[][] v1 = {{1, 4}, {3, 4}, {3, 10}};
        System.out.println(Arrays.toString(solution.solution(v1)));
    }

    public int[] solution(int[][] v) {
        Set<Integer> x = new HashSet<>();
        Set<Integer> y = new HashSet<>();

        for (int[] arr : v) {
            if (x.contains(arr[0])) x.remove(arr[0]);
            else x.add(arr[0]);

            if (y.contains(arr[1])) y.remove(arr[1]);
            else y.add(arr[1]);
        }

        return new int[]{(int) x.toArray()[0], (int) y.toArray()[0]};
    }
}
