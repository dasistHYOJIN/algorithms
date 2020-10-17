package programmers;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        int[] numbers1 = {10, 40, 30, 20};
        int[] numbers2 = {3, 7, 2, 8, 6, 4, 5, 1};
        System.out.println(solution.solution(numbers1, 20));
        System.out.println(solution.solution(numbers2, 3));

    }

    public int solution(int[] numbers, int K) {
        return asdf(numbers, 0, 0, K);
    }

    private int asdf(int[] numbers, int index, int count, int K) {
        if (index == numbers.length - 1) {
            Arrays.stream(numbers).forEach(i -> System.out.print(i + " "));
            System.out.println();

            if (!df(numbers, K)) return Integer.MAX_VALUE;
            System.out.println(count);
            return count;
        }

        int a = asdf(numbers.clone(), index + 1, count, K);

        swap(numbers, index, index + 1);
        int b = asdf(numbers.clone(), index + 1, count + 1, K);

        return Math.min(a, b);
    }

    private boolean df(final int[] numbers, final int K) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (Math.abs(numbers[i] - numbers[i + 1]) > K) {
                System.out.println(numbers[i] +" - " + numbers[i + 1]+" "+ Math.abs(numbers[i] - numbers[i + 1]));
                return false;
            }
        }
        return true;
    }

    private void swap(int[] numbers, int i1, int i2) {
        int temp = numbers[i1];
        numbers[i1] = numbers[i2];
        numbers[i2] = temp;
    }
}
