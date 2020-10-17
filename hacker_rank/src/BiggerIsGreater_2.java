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
        /*String[] ss = ("zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgmw\n" +
                "zyyxwwtrrnmlggfeb\n" +
                "ocsmerkgidvddsazqxjbqlrrxcotrnfvtnlutlfcafdlwiismslaytqdbvlmcpapfbmzxmftrkkqvkpflxpezzapllerxyzlcf\n" +
                "biehzcmjckznhwrfgglverxsezxuqpj\n" +
                "rebjvsszebhehuojrkkhszxltyqfdvayusylgmgkdivzlpmmtvbsavxvydldmsym\n" +
                "unpzhmbgrrs\n" +
                "jprfovzkdlmdcesdcpdchcwoedjchcovklhrhlzfeeptoewcqpxg\n" +
                "ywsfmynmiylcjgrfrrmtyeeykffzkuphpajndwxjteyjba\n" +
                "dkuashjzsdq\n" +
                "gwakhcpkolybihkmxyecrdhsvycjrljajlmlqgpcnmvvkjlkvdowzdfikh\n" +
                "nebsajjbbuifimjpdcqfygeitief\n" +
                "qetpicxagjkydehfnvfxrtigljlheulcsfidjjozbsnomygqbcmpffwswptbgkzrbgqwnczrcfynjmhebfbgseuhckbtuynvbo\n" +
                "xuqfobndhsnsztifmqpnencxkllnpmbfqihtgdgxjhsvitlgtodhcydfb\n" +
                "xqdwkjpkmrvkfnztozzlqtuxzxyxwowf\n" +
                "yewluyxiwiprnajrtkeilolkmqidazhiar\n" +
                "zzyyxxxxxwwwwwvvvvutttttsssssrrrrqqqppponnnnmmmmllkkjjjjiiggffffffeedddddbbbbbba\n" +
                "hlvpzsfwnzsazeyaxaczkkrstiilkldupsqmzjnnsyoao\n" +
                "zxvuutttrrrpoookiihhgggfdca").split("\n");
        for (String s : ss) {
            System.out.println(biggerIsGreater(s));
        }*/
        System.out.println(biggerIsGreater("abcdeba"));
    }

    static String biggerIsGreater(String input) {
        int index = findCrescendo(input);
        System.out.println(index);

        if (input.length() == 1 || index == 0 && (input.charAt(index) >= input.charAt(index + 1))) return "no answer";

        String substring = input.substring(index);

        List<String> randomWords = new ArrayList<>();
        permutation(substring.toCharArray(), randomWords, substring.length());

        System.out.println(randomWords);
        Collections.sort(randomWords);
        System.out.println(randomWords);

        int substringAt = randomWords.indexOf(substring);
        return input.substring(0, index) + randomWords.get(substringAt + 1);
    }

    private static int findCrescendo(String input) {
        int i = input.length() - 2;
        for (; 0 < i; i--) {
            if (input.charAt(i) < input.charAt(i + 1)) {
                break;
            }
        }
        return i;
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
