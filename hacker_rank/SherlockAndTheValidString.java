package hacker_rank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAndTheValidString {
    public static void main(String[] args) {
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println(isValid("aa"));
        System.out.println(isValid("aabbc"));
    }

    static String isValid(String s) {
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, (map.containsKey(c)) ? map.get(c) + 1 : 1);
        }

        Object[] objects = map.values().toArray();
        Arrays.sort(objects);

        return ((objects.length == 1) || ((int) objects[0] + 1 == (int) objects[1])
                || ((int) objects[objects.length - 2] + 1 == (int) objects[objects.length - 1])) ? "YES" : "NO";
    }
}
