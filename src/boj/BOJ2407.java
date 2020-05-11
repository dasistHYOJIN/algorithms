package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2407 {
    private static int N, M;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            combination(i, 1);
        }

        System.out.println(result);
    }

    private static void combination(int index, int count) {
        if (count == M) {
            result++;
            return;
        }
        if (index >= N) return;

        combination(index + 1, count + 1); // 이번 거 포함
        combination(index + 1, count); // 이번 거 불포함
    }
}
