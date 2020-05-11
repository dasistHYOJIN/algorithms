package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while (T-- > 0) {
            String input = br.readLine();

            if (input.startsWith(")")) {
                result.append("NO").append("\n");
                continue;
            }

            Stack<Character> s1 = pushAllCharacters(input);
            Stack<Character> s2 = new Stack<>();

            while (!s1.isEmpty()) {
                if (s2.isEmpty() || !isPair(s1.peek(), s2.peek())) {
                    s2.push(s1.pop());
                } else {
                    s1.pop();
                    s2.pop();
                }
            }

            result.append(s2.isEmpty() ? "YES" : "NO").append("\n");
        }

        System.out.println(result.toString());
    }

    private static Stack<Character> pushAllCharacters(final String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        return stack;
    }

    private static boolean isPair(char c1, char c2) {
        return ((c1 == '(') && (c2 == ')'));
    }
}
