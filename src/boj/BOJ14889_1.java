package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14889_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        int result = Integer.MAX_VALUE;

        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        // 1~N까지의 수를 반으로 가르는 모든 경우 구하기
        List<int[]> teams = new ArrayList<>();
        separateTeam(teams, N, N / 2, 0, 0, new int[N / 2]);
        List<int[]> start = teams.subList(0, teams.size() / 2);
        List<int[]> link = teams.subList(teams.size() / 2, teams.size());
        Collections.reverse(link);

        // 각 경우에 대해 능력치 차 구하기
        for (int i = 0; i < start.size(); i++) {
            result = Integer.min(result, compareStats(board, start.get(i), link.get(i)));
        }

        System.out.println(result);
    }

    private static void separateTeam(List<int[]> teams, int N, int R, int index, int target, int[] team) {
        if (R == 0) {
            teams.add(team.clone());
            return;
        }
        if (target == N) return;

        team[index] = target;
        separateTeam(teams, N, R - 1, index + 1, target + 1, team);
        separateTeam(teams, N, R, index, target + 1, team);
    }

    private static int compareStats(int[][] board, int[] start, int[] link) {
        int startScore = calculateStats(board, start);
        int linkScore = calculateStats(board, link);

        return Math.abs(startScore - linkScore);
    }

    private static int calculateStats(int[][] board, int[] team) {
        int sum = 0;

        for (int i = 0; i < team.length - 1; i++) {
            for (int j = i + 1; j < team.length; j++) {
                sum += board[team[i]][team[j]];
                sum += board[team[j]][team[i]];
            }
        }

        return sum;
    }

}
