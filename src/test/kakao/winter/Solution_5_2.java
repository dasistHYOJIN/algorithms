package test.kakao.winter;

public class Solution_5_2 {
    public static void main(String[] args) {
        Solution_5_2 solution = new Solution_5_2();

        int[] stones1 = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        System.out.println(solution.solution(stones1, 3));

        int[] stones2 = {1, 1, 1, 1, 1};
        System.out.println(solution.solution(stones2, 3));

        int[] stones3 = {1};
        System.out.println(solution.solution(stones3, 1));
    }

    public int solution(int[] stones, int k) {
        int answer = 0;

        int count = 0;
        outer:
        while (true) {
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] == 0) {
                    count++;
                } else {
                    stones[i]--;
                    count = 0;
                }

                if (count >= k) break outer;
            }
            answer++;
        }

        return answer;
    }

}
