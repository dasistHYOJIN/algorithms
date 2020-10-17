package hacker_rank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class TheBombermanGame_1 {
    private static int[] moveX = {0, 0, -1, 1};
    private static int[] moveY = {-1, 1, 0, 0};

    private static int X, Y;

    public static void main(String[] args) {

        String[] grid1 = (".......\n"
                + "...O...\n"
                + "....O..\n"
                + ".......\n"
                + "OO.....\n"
                + "OO.....").split("\n");
        System.out.println(String.join("\n", bomberMan(3, grid1)));

        String[] grid2 = (
                ".......\n" +
                        "...O.O.\n" +
                        "....O..\n" +
                        "..O....\n" +
                        "OO...OO\n" +
                        "OO.O...").split("\n");
        System.out.println(String.join("\n", bomberMan(5, grid2)));

        String[] grid3 = (
                "...\n" +
                        ".O.\n" +
                        "...").split("\n");
        System.out.println(String.join("\n", bomberMan(3, grid3)));
    }

    static String[] bomberMan(int n, String[] grid) {
        X = grid[0].length();
        Y = grid.length;

        int[][] seconds = initSecond(grid);

        while (--n > 0) {
            plantBomb(seconds);

            Queue<Position> expiredBombs = searchExpiredBombs(seconds);
            System.out.println(expiredBombs);
            detonateBomb(seconds, expiredBombs);

            for (int[] second : seconds) {
                System.out.println(Arrays.toString(second));
            }
        }

        return convertToString(seconds);
    }

    private static void detonateBomb(int[][] seconds, Queue<Position> expiredBombs) {
        while (!expiredBombs.isEmpty()) {
            Position bomb = expiredBombs.poll();

            for (int i = 0; i < 4; i++) {
                int dx = bomb.x + moveX[i];
                int dy = bomb.y + moveY[i];

                if (dx < 0 || dy < 0 || dx >= X || dy >= Y) continue;
                if (expiredBombs.contains(new Position(dx, dy))) continue;

                seconds[bomb.y][bomb.x] = 0;
                seconds[dy][dx] = 0;
            }
        }
    }

    private static void plantBomb(int[][] seconds) {
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                seconds[y][x]++;
            }
        }
    }

    private static Queue<Position> searchExpiredBombs(int[][] seconds) {
        Queue<Position> bombs = new LinkedList<>();
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if ((seconds[y][x] / 3) > 0 && (seconds[y][x] % 3) == 0) bombs.add(new Position(x, y));
            }
        }

        return bombs;
    }

    private static int[][] initSecond(String[] grid) {
        int[][] seconds = new int[Y][X];

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                seconds[y][x] = (grid[y].charAt(x) == 'O') ? 1 : 0;
            }
        }

        return seconds;
    }

    private static String[] convertToString(int[][] seconds) {
        StringBuilder result = new StringBuilder();
        for (int[] second : seconds) {
            for (int s : second) {
                result.append(s > 1 ? 'O' : '.');
            }
            result.append("\n");
        }
        return result.toString().split("\n");
    }

    private static class Position {
        int x;
        int y;

        public Position(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ')';
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
