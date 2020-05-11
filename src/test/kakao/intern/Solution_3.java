package test.kakao.intern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_3 {
    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();

        String[] s1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//        System.out.println(Arrays.toString(solution.solution(s1)));

        String[] s2 = {"a", "b", "c", "a", "a", "b", "c", "d", "e", "c", "a", "b", "e", "f"};
        System.out.println(Arrays.toString(solution.solution(s2)));
    }

    public int[] solution(String[] gems) {
        int countOfGems = (int) Arrays.stream(gems).distinct().count();

        for (int length = countOfGems; length <= gems.length; length++) {
            for (int p = 0; p + length <= gems.length; p++) {
                Map<String, Integer> dictionary = initDictionary(gems, p, p + length);
                if (dictionary.size() == countOfGems) {
                    return new int[]{p + 1, p + length};
                }

                int[] result = iterate(dictionary, gems, p + 1, length, countOfGems);
                if (result != null) return result;
            }
        }

        return new int[]{1, gems.length};
    }

    private int[] iterate(Map<String, Integer> dictionary, String[] gems, int startIndex, int length, int countOfGems) {
        for (int i = startIndex; i + length < gems.length; i++) {
            // 직전 글자 하나 빼기
            String gemOfBefore = gems[i - 1];
            int numOfBefore = dictionary.get(gemOfBefore);

            if (numOfBefore == 1) dictionary.remove(gemOfBefore);
            else dictionary.put(gemOfBefore, numOfBefore - 1);

            // 이번 글자 끝에 거 하나 넣기
            String gemOfThis = gems[i + length - 1];
            int numOfThis = dictionary.getOrDefault(gemOfThis, 0);

            dictionary.put(gemOfThis, numOfThis + 1);

            // 초기 맵이랑 같냐
            if (dictionary.size() == countOfGems) {
                return new int[]{i + 1, i + length};
            }
        }

        return null;
    }

    private Map<String, Integer> initDictionary(String[] gems, int startIndex, long endIndex) {
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = startIndex; i < endIndex; i++) {
            dictionary.put(gems[i], (dictionary.containsKey(gems[i]) ? dictionary.get(gems[i]) + 1 : 1));
        }

        return dictionary;
    }
}
