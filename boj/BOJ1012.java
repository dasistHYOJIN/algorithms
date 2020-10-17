package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1012 {
    private static int[] moveX = {0, 0, -1, 1};
    private static int[] moveY = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            boolean[][] cabbages = initCabbages(br, M, N, K);
            int wormCount = 0;

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (!cabbages[y][x]) continue;

                    doBfs(cabbages, new Position(x, y), M, N);
                    wormCount++;
                }
            }

            result.append(wormCount).append("\n");
        }

        System.out.println(result.toString());
    }

    private static void doBfs(boolean[][] cabbages, Position position, int M, int N) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(position);

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int x = pos.x;
            int y = pos.y;

            cabbages[y][x] = false;

            for (int i = 0; i < 4; i++) {
                int dx = x + moveX[i];
                int dy = y + moveY[i];

                if (dx < 0 || dy < 0 || dx >= M || dy >= N) continue;
                if (!cabbages[dy][dx]) continue;

                queue.add(new Position(dx, dy));
            }

        }
    }

    private static boolean[][] initCabbages(final BufferedReader br, final int m, final int n, int k) throws IOException {
        StringTokenizer st;
        boolean[][] worms = new boolean[n][m];

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            worms[Y][X] = true;
        }
        return worms;
    }

    private static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
