package hacker_rank;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectedCellsInAGrid {
    // 상-하-좌-우-좌상-우상-좌하-우하
    private final static int[] moveX = {0, 0, -1, 1, -1, 1, -1, 1};
    private final static int[] moveY = {-1, 1, 0, 0, -1, -1, 1, 1};

    private static int X, Y;

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0}};
        System.out.println(connectedCell(matrix1));

        int[][] matrix2 = {
                {0, 0, 1, 1},
                {0, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        System.out.println(connectedCell(matrix2));
    }

    static int connectedCell(int[][] matrix) {
        X = matrix[0].length;
        Y = matrix.length;

        int largestRegion = 0;

        // visited 선언
        boolean[][] visited = new boolean[Y][X];

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (matrix[y][x] == 0 || visited[y][x]) continue;

                // 1 나올 때마다 탐색하면서 visited true
                largestRegion = Math.max(largestRegion, bfs(matrix, visited, x, y));
            }
        }

        // 탐색이 끝나면 영역의 크기 return
        return largestRegion;
    }

    private static int bfs(int[][] matrix, boolean[][] visited, int x, int y) {
        int region = 0;

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            for (int i = 0; i < 8; i++) {
                int dx = pos.x + moveX[i];
                int dy = pos.y + moveY[i];

                if (dx < 0 || dx >= X || dy < 0 || dy >= Y) continue;
                if (visited[dy][dx] || matrix[dy][dx] == 0) continue;

                visited[dy][dx] = true;
                queue.add(new Position(dx, dy));
            }

            region++;
        }

        return region;
    }

    private static class Position {
        int x;
        int y;

        Position(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }

}
