package hacker_rank;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 * 처음에는 단순히 2차원 배열을 만들어서 탐색을 해야겠다고 생각했는데
 * 문제의 조건이 10^5이라서 기존 방식대로 하면 heap 메모리 뻑나기 때문에
 * hashMap으로 대체하여 해결
 * */

public class QueensAttack2 {
    // 상 하 좌 우 좌상 우상 좌하 우하
    private static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    private static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) {
        int[][] obstacles1 = {{5, 5}, {4, 2}, {2, 3}};
        System.out.println(queensAttack(5, 3, 4, 3, obstacles1));

        int[][] obstacles2 = {{1, 1}};
        System.out.println(queensAttack(1, 0, 1, 1, obstacles2));

        int[][] obstacles3 = {{1, 1}};
        System.out.println(queensAttack(100000, 0, 4187, 5068, obstacles3));
    }

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        Map<String, Boolean> board = new HashMap<>();

        for (int i = 0; i < k; i++) {
            int y = n - obstacles[i][0];
            int x = obstacles[i][1] - 1;

            board.put(String.format("%d %d", y, x), true);
        }

        int count = 0;
        r_q = n - r_q;
        c_q = c_q - 1;

        for (int i = 0; i < 8; i++) {
            int newY = r_q;
            int newX = c_q;

            while (true) {
                newX += dx[i];
                newY += dy[i];

                if (newX < 0 || newY < 0 || newX >= n || newY >= n) break;
                if (board.containsKey(String.format("%d %d", newY, newX))) break;

                count++;
            }
        }

        return count;
    }

    private static boolean[][] initBoard(int n, int k, int[][] obstacles) {
        boolean[][] board = new boolean[n][n];

        for (int i = 0; i < k; i++) {
            int y = n - obstacles[i][0];
            int x = obstacles[i][1] - 1;

            board[y][x] = true;
        }

        return board;
    }

    public static class Position {
        int y;
        int x;

        Position(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x &&
                    y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
