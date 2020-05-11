package hacker_rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 두 번째 풀이방법
 * 1. 문자열을 구성하는 모든 문자로 가능한 모든 조합
 * 2. 중복 제거
 * 3. 리스트 정렬 후 다음 인덱스
 *
 * 문자열이 길수록 시간이 오래 걸리게 됨
 * O(n!)
 **/

public class BiggerIsGreater_2 {
    public static void main(String[] args) {
//        System.out.println(biggerIsGreater("ab"));
//        System.out.println(biggerIsGreater("bb"));
//        System.out.println(biggerIsGreater("hefg"));
//        System.out.println(biggerIsGreater("dhck"));
//        System.out.println(biggerIsGreater("dkhc"));
//        System.out.println(biggerIsGreater("lmno"));
//        System.out.println(biggerIsGreater("dcba"));
//        System.out.println(biggerIsGreater("dcbb"));
//        System.out.println(biggerIsGreater("abdc"));
//        System.out.println(biggerIsGreater("abcd"));
//        System.out.println(biggerIsGreater("fedcbabcd"));
        System.out.println(biggerIsGreater("adbec"));
        System.out.println(biggerIsGreater("dacbe"));
    }

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String input) {
        List<String> randomWords = new ArrayList<>();
        randomWords.add(input);

        permutation(input.toCharArray(), randomWords, input.length());

        Collections.sort(randomWords);

        int inputAt = randomWords.indexOf(input);
        return (inputAt == randomWords.size() - 1) ? "no answer" : randomWords.get(inputAt + 1);
    }

    static void permutation(char[] words, List<String> randomWords, int n) {
        if (n == 0) {
            String s = String.valueOf(words);
            if (!randomWords.contains(s)) randomWords.add(s);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(words, i, n - 1);
            permutation(words, randomWords, n - 1);
            swap(words, i, n - 1);
        }
    }

    static void swap(char[] words, int i1, int i2) {
        char temp = words[i1];
        words[i1] = words[i2];
        words[i2] = temp;
    }
}
