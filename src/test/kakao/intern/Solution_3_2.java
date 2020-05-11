package test.kakao.intern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_3_2 {
    public static void main(String[] args) {
        Solution_3_2 solution = new Solution_3_2();

        String[] s1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(solution.solution(s1)));

        String[] s2 = {"a", "b", "c", "a", "a", "b", "c", "d", "e", "c", "a", "b", "e", "f"};
//        System.out.println(Arrays.toString(solution.solution(s2)));
    }

    public int[] solution(String[] gems) {
        Map<String, Integer> dictionary = initDictionary(gems);

        int indexOfEnd = narrowDown(dictionary, gems, gems.length - 1, -1);
        int indexOfStart = narrowDown(dictionary, gems, 0, 1);

        return new int[]{indexOfStart + 1, indexOfEnd + 1};
    }

    private Map<String, Integer> initDictionary(String[] gems) {
        Map<String, Integer> dictionary = new HashMap<>();

        for (String gem : gems) {
            dictionary.put(gem, dictionary.getOrDefault(gem, 0) + 1);
        }

        return dictionary;
    }

    private int narrowDown(Map<String, Integer> dictionary, String[] gems, int startPoint, int direction) {
        int i = startPoint;
        while (true) {
            String gem = gems[i];

            if (dictionary.get(gem) == 1) break;

            dictionary.put(gem, dictionary.get(gem) - 1);
            i += direction;
        }
        return i;
    }

}
