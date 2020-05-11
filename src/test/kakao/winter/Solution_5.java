package test.kakao.winter;

import java.util.HashMap;
import java.util.Map;

public class Solution_5 {
    public static void main(String[] args) {
        Solution_5 solution = new Solution_5();

        int[] stones1 = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        System.out.println(solution.solution(stones1, 3));

        int[] stones2 = {1, 1, 1, 1, 1};
        System.out.println(solution.solution(stones2, 3));

        int[] stones3 = {1};
        System.out.println(solution.solution(stones3, 1));
    }

    public int solution(int[] stones, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;

        outer:
        while (map.size() < stones.length) {
            answer++;
            int i = 0;
            while (i < stones.length) {
                int orDefault = nextStone(map, i + 1);
                if (stones[i] == answer) {
                    if (orDefault - i >= k) break outer;
                    map.put(i, orDefault);
                }

                i = orDefault;
            }
        }

        return answer;
    }

    private int nextStone(Map<Integer, Integer> map, int key) {
        if (map.containsKey(key)) {
            return nextStone(map, map.get(key));
        }
        return key;
    }
}
