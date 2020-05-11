package hacker_rank;

import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams_2 {
    public static void main(String[] args) {
//        System.out.println(sherlockAndAnagrams("abba"));
//        System.out.println(sherlockAndAnagrams("abcba"));
        System.out.println(sherlockAndAnagrams("ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel"));
//        System.out.println(sherlockAndAnagrams("ifailuhkqq"));
//        System.out.println(sherlockAndAnagrams("kkkk"));
//        System.out.println(sherlockAndAnagrams("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    static int sherlockAndAnagrams(String s) {
        int result = 0;

        for (int p = 0; p < s.length() - 1; p++) {
            for (int length = 1; p + length < s.length(); length++) {
                // 맵에 넣고
                Map<Character, Integer> dictionary = initDictionary(s.substring(p, p + length));

                // p+1부터 끝까지 같은 길이로 넣었다 뺐다 했을 때 초기 맵이랑 같으면 count++
                result += iterate(dictionary, new HashMap<>(dictionary), s, p + 1, length);
            }
        }

        return result;
    }

    private static int iterate(Map<Character, Integer> dictionary, Map<Character, Integer> target, String s, int startIndex, int length) {
        // p+1부터 끝까지 같은 길이로 넣었다 뺐다 했을 때 초기 맵이랑 같으면 count++
        int count = 0;

        for (int p = startIndex; p + length <= s.length(); p++) {
            // 직전 글자 하나 빼기
            char charOfBefore = s.charAt(p - 1);
            int numOfBefore = dictionary.get(charOfBefore);

            if (numOfBefore == 1) dictionary.remove(charOfBefore);
            else dictionary.put(charOfBefore, numOfBefore - 1);

            // 이번 글자 끝에 거 하나 넣기
            char charOfThis = s.charAt(p + length - 1);
            int numOfThis = dictionary.getOrDefault(charOfThis, 0);

            dictionary.put(charOfThis, numOfThis + 1);

            // 초기 맵이랑 같냐
            if (dictionary.equals(target)) count++;
        }

        return count;
    }

    private static Map<Character, Integer> initDictionary(String substring) {
        Map<Character, Integer> dictionary = new HashMap<>();
        for (char c : substring.toCharArray()) {
            dictionary.put(c, (dictionary.containsKey(c)) ? dictionary.get(c) + 1 : 1);
        }

        return dictionary;
    }

}
