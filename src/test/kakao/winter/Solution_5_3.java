package test.kakao.winter;

public class Solution_5_3 {
    public static void main(String[] args) {
        Solution_5_3 solution = new Solution_5_3();

        int[] stones1 = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        System.out.println(solution.solution(stones1, 3));

        int[] stones2 = {1, 1, 1, 1, 1};
        System.out.println(solution.solution(stones2, 3));

        int[] stones3 = {1};
        System.out.println(solution.solution(stones3, 1));
    }

    public int solution(int[] stones, int k) {
        int min = Integer.MAX_VALUE;
        for (int p = 0; p <= stones.length - k; p++) {
            min = Math.min(min, getMaxIndex(stones, p, k));
        }

        return min;
    }

    private int getMaxIndex(int[] stones, int p, int k) {
        int maxIndex = 0;
        for (int i = p; i < p + k; i++) {
            maxIndex = Math.max(maxIndex, stones[i]);
        }
        return maxIndex;
    }

}
