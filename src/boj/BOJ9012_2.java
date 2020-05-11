package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9012_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while (T-- > 0) {
            String input = br.readLine();

            while (input.contains("()")) {
                input = input.replaceAll("\\(\\)", "");
            }

            result.append(input.length() == 0 ? "YES" : "NO").append("\n");
        }

        System.out.println(result.toString());
    }
}
