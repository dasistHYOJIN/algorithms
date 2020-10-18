import java.io.*;
import java.util.StringTokenizer;

/** X, Y 값을 잘 보자..! **/
public class BOJ14499 {
    private static final int EAST = 1;
    private static final int WEST = 2;
    private static final int NORTH = 3;
    private static final int SOUTH = 4;

    private static final int UP = 0;
    private static final int BOTTOM = 5;

    private static BufferedReader br;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter result = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Position current = new Position(X, Y);

        int[] dice = {0, 0, 0, 0, 0, 0};
        int[][] map = new int[N][M];

        initDice(map, N, M);

        StringTokenizer commands = new StringTokenizer(br.readLine());
        while (K-- > 0) {
            int command = Integer.parseInt(commands.nextToken());

            Position next = nextPosition(current, command);
            if (next == null) continue;
            else current = next;

            rollDice(dice, command);

            int x = current.x;
            int y = current.y;
            if (map[y][x] == 0) {
                map[y][x] = dice[BOTTOM];
            } else {
                dice[BOTTOM] = map[y][x];
                map[y][x] = 0;
            }

            result.append(String.valueOf(dice[UP])).append("\n");
        }

        result.flush();

    }

    private static void initDice(int[][] map, int n, int m) throws IOException {
        StringTokenizer st;
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void rollDice(int[] dice, int direction) {
        switch (direction) {
            case EAST:
                int temp = dice[2];
                dice[2] = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = temp;
                break;
            case WEST:
                temp = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = temp;
                break;
            case NORTH:
                temp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;
                break;
            case SOUTH:
                temp = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[4];
                dice[4] = temp;
                break;
        }
    }

    private static Position nextPosition(Position current, int direction) {
        int x = current.x;
        int y = current.y;

        switch (direction) {
            case EAST:
                if (x == M - 1) break;
                return new Position(x + 1, y);
            case WEST:
                if (x == 0) break;
                return new Position(x - 1, y);
            case NORTH:
                if (y == 0) break;
                return new Position(x, y - 1);
            case SOUTH:
                if (y == N - 1) break;
                return new Position(x, y + 1);
        }

        return null;
    }

    public static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
