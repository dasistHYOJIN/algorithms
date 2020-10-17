package hacker_rank;

import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams_1 {
    public static void main(String[] args) {
//        System.out.println(sherlockAndAnagrams("abba"));
//        System.out.println(sherlockAndAnagrams("acdb"));
//        System.out.println(sherlockAndAnagrams("ifailuhkqq"));
//        System.out.println(sherlockAndAnagrams("kkkk"));
        System.out.println(sherlockAndAnagrams("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    static int sherlockAndAnagrams(String s) {
        int result = 0;

        for (int length = 1; length < s.length(); length++) {
            for (int p = 0; p + length < s.length(); p++) {
                Map<Character, Integer> dictionary = new HashMap<>();
                for (char c : s.substring(p, p + length).toCharArray()) {
                    dictionary.put(c, dictionary.containsKey(c) ? dictionary.get(c) + 1 : 1);
                }

                result += search(dictionary, new HashMap<>(dictionary), s, p + 1, length);
            }
        }

        return result;
    }

    private static int search(Map<Character, Integer> dictionary, Map<Character, Integer> target, String input, int startIndex, int length) {
        int count = 0;

        for (int p = startIndex; p + length <= input.length(); p++) {
            char beforeChar = input.charAt(p - 1);
            if (dictionary.get(beforeChar) == 1) dictionary.remove(beforeChar);
            else dictionary.put(beforeChar, dictionary.get(beforeChar) - 1);

            int lastIndex = p + length;
            dictionary.put(input.charAt(lastIndex - 1), dictionary.containsKey(input.charAt(lastIndex - 1)) ? dictionary.get(input.charAt(lastIndex - 1)) + 1 : 1);

            count += dictionary.equals(target) ? 1 : 0;
        }

        return count;
    }
}
