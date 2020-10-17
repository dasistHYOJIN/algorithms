package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Stack<Character> s1 = pushAllCharsIntoStack(input);
        Stack<Character> s2 = new Stack<>();

        int score = 0;

        char c;
        while (!s1.isEmpty()) {

            if (s2.isEmpty() || isNotPair(s1.peek(), s2.peek())) {
                s2.push(s1.pop());
            } else {
                s1.pop();
                s2.pop();
            }
            c = s1.pop();

        }

        System.out.println(s2.isEmpty() ? score : 0);
    }

    private static int getEachScore(char c) {
        if (c == '(' || c == ')') return 2;
        if (c == '{' || c == '}') return 3;
        return 0;
    }

    private static boolean isOpenCharacter(char c) {
        return (c == '(') || (c == '{');
    }

    private static boolean isNotPair(char c1, char c2) {
        switch (c1) {
            case '(':
                return c2 == ')';
            case '{':
                return c2 == '}';
            default:
                return false;
        }
    }

    private static Stack<Character> pushAllCharsIntoStack(String input) {
        Stack<Character> stack = new Stack<>();

        for (char item : input.toCharArray()) {
            stack.push(item);
        }

        return stack;
    }
}
