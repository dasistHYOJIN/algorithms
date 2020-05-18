package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        for (int y = 0; y < 8; y++) {
            String input = br.readLine();
            for (int x = y % 2; x < input.length(); x += 2) {
                count += (input.charAt(x) == 'F') ? 1 : 0;
            }
        }

        System.out.println(count);
    }
}
