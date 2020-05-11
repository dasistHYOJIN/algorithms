package kakao.intern.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < b; i++) {
            result.append("*".repeat(Math.max(0, a)));
            result.append('\n');
        }

        System.out.println(result.toString());
    }
}
