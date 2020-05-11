package hacker_rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 세 번째 풀이방법
 * 1. 순열을 쓰긴 쓰되 부분적으로만 순열
 * 2.
 * 3.
 *
 * 문자열이 길수록 시간이 오래 걸리게 됨
 * O(n!)
 **/

public class BiggerIsGreater_3 {
    public static void main(String[] args) {
//        System.out.println(biggerIsGreater("ab"));
//        System.out.println(biggerIsGreater("bb"));
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
    static String biggerIsGreater(String input) {

        int i = findIndex(input);
        String baseInput = input.substring(0, 2);

        String randomInput = input.substring(2);
        List<String> randomWords = new ArrayList<>();
        randomWords.add(randomInput);

        permutation(randomInput.toCharArray(), randomWords, randomInput.length());

        Collections.sort(randomWords);

        int inputAt = randomWords.indexOf(input);
        return (inputAt == randomWords.size() - 1) ? "no answer" : baseInput + randomWords.get(inputAt + 1);
    }

    private static int findIndex(String input) {
        char key = input.charAt(input.length() - 1);
        for (int i = input.length()-1; i >= 0 ; i--) {

        }
        return 0;
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
