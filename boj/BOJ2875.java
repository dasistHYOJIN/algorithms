package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int team = 0;

        // 우선 팀을 만들고
        while (N >= 2 && M >= 1) {
            N -= 2;
            M -= 1;
            team++;
        }

        // 남은 인원 수로 K를 채우고
        K -= N + M;

        // 그래도 모자라면 팀을 해체하고
        while (K > 0) {
            K -= 3;
            team--;
        }

        // 남은 팀 수 구하기
        System.out.println(team);
    }
}
