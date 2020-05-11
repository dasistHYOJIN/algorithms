package hacker_rank;

import java.util.Arrays;

// 문제를 제대로 읽자!
// 틀린 이유:

public class Encryption {
    public static void main(String[] args) {
        System.out.println(encryption("if man was meant to stay on the ground god would have given us roots"));
        System.out.println(encryption("chillout"));
        System.out.println(encryption("feedthedog"));
        System.out.println(encryption("iffactsdontfittotheorychangethefacts"));
    }

    // Complete the encryption function below.
    static String encryption(String s) {
        // remove space
        s = s.replaceAll(" ", "");

        int row = (int) Math.ceil(Math.sqrt(s.length()));

        StringBuilder[] encryption = new StringBuilder[row];
        Arrays.setAll(encryption, i -> new StringBuilder());

        int index = 0;
        for (char c : s.toCharArray()) {
            encryption[index].append(c);
            index = (index + 1) % row;
        }

        return String.join(" ", encryption);
    }
}
