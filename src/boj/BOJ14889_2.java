package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ14889_2 {
    private static int N;
    private static int[][] stats;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stats = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                stats[i][j] = Integer.parseInt(input[j]);
            }
        }

        combination(new int[N / 2], N / 2, 0, 0);

        System.out.println(min);
    }

    private static void combination(int[] team, int R, int index, int player) {
        if (R == 0) {
            List<Integer> start = new ArrayList<>();
            List<Integer> link = new ArrayList<>();
            createTeam(team, start, link);

            min = Math.min(min, calculateStats(start, link));
            return;
        }
        if (N == player) return;

        team[index] = player;
        combination(team, R - 1, index + 1, player + 1);
        combination(team, R, index, player + 1);
    }

    private static int calculateStats(final List<Integer> start, final List<Integer> link) {
        int startStats = 0;
        int linkStats = 0;

        for (int i = 0; i < start.size() - 1; i++) {
            for (int j = i + 1; j < start.size(); j++) {
                startStats += stats[start.get(i)][start.get(j)] + stats[start.get(j)][start.get(i)];
                linkStats += stats[link.get(i)][link.get(j)] + stats[link.get(j)][link.get(i)];
            }
        }

        return Math.abs(startStats - linkStats);
    }

    private static void createTeam(int[] team, List<Integer> start, List<Integer> link) {
        for (int i = 0; i < N; i++) {
            if (Arrays.binarySearch(team, i) >= 0) start.add(i);
            else link.add(i);
        }
    }
}
