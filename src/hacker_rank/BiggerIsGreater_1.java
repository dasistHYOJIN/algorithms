package hacker_rank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        // 문자열을 배열로 변환
        char[] arrayWords = w.toCharArray();
        char[] sortedArrayWord = w.toCharArray();
        Arrays.sort(sortedArrayWord);

        // 숫자를 +1 하다가
        while (countUp(arrayWords, arrayWords.length - 1)) {
            // 각 자릿수가 숫자로 변환된 문자열의 구성과 같으면 break
            char[] numericW = arrayWords.clone();
            Arrays.sort(numericW);

            if (Arrays.equals(sortedArrayWord, numericW)) break;
        }

        Set<Character> set = new HashSet<>();
        for (char c : arrayWords) {
            set.add(c);
        }

        // 숫자를 문자열로 다시 변환
        String result = String.valueOf(arrayWords);

        return (w.equals(result) || set.size() == 1) ? "no answer" : result;
    }

    private static boolean countUp(char[] numericW, int index) {
        if (index < 0) return false;

        if (numericW[index] >= 'z') {
            numericW[index] = 'a';
            return countUp(numericW, index - 1);
        }

        numericW[index] += 1;
        return true;
    }
}
