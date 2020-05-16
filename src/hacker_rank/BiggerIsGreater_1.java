package hacker_rank;

import java.util.*;
import java.util.stream.Collectors;

/*
 * 첫 번째 풀이방법
 * 1. 문자열을 char[] 배열로 변환한 후
 * 2-1. 가장 오른쪽 문자부터 +1씩 증가시킴
 * 2-2. 만약 0번 인덱스 문자까지 다 증가시켜도 답이 안나오면 no answer
 * 3. 원래 문자 구성과 같은 구성의 배열이 되면 return
 *
 * O(26^n)
 **/

public class BiggerIsGreater_1 {
    public static void main(String[] args) {
        System.out.println(biggerIsGreater("ab"));
        System.out.println(biggerIsGreater("bb"));
        System.out.println(biggerIsGreater("hefg"));
        System.out.println(biggerIsGreater("dhck"));
        System.out.println(biggerIsGreater("dkhc"));
        System.out.println(biggerIsGreater("lmno"));
        System.out.println(biggerIsGreater("dcba"));
        System.out.println(biggerIsGreater("dcbb"));
        System.out.println(biggerIsGreater("abdc"));
        System.out.println(biggerIsGreater("abcd"));
        System.out.println(biggerIsGreater("fedcbabcd"));
        System.out.println(biggerIsGreater("abdec"));
    }

    static String biggerIsGreater(String input) {
        List<Character> chars = charsToList(input);
        Map<Character, Long> dictionary = chars.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        // 가장 클 때
        char[] sortedChars = input.toCharArray();
        Arrays.sort(sortedChars);
        String sortedInput = new StringBuilder(String.valueOf(sortedChars)).reverse().toString();
        if (sortedInput.equals(input)) {
            return "no answer";
        }

        do {
            add(chars, chars.size() - 1);
        } while (!dictionary.equals(chars.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()))));

        char[] result = new char[chars.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = chars.get(i);
        }
        return String.valueOf(result);
    }

    private static void add(List<Character> chars, int index) {
        int c = chars.get(index) + 1;
        chars.set(index, (char) (('z' < c) ? 'a' : c));
        if ((c / ('z' + 1)) > 0) add(chars, index - 1);
    }

    private static List<Character> charsToList(String input) {
        List<Character> dictionary = new ArrayList<>();
        char[] chars = input.toCharArray();
        for (char c : chars) {
            dictionary.add(c);
        }
        return dictionary;
    }
}
