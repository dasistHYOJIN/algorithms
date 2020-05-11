package test.kakao.intern;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_4 {
    private static int[] moveX = {0, 0, -1, 1};
    private static int[] moveY = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Solution_4 solution = new Solution_4();

        int[][] board1 = {{0, 1, 0}, {0, 0, 0}, {1, 0, 0}};
//        System.out.println(solution.solution(board1));

        int[][] board2 = {
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(solution.solution(board2));

        int[][] board3 = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};
//        System.out.println(solution.solution(board3));
    }

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        int N = board.length;
        int[][] visited = new int[N][N];

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, 0, null));

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int x = pos.x;
            int y = pos.y;

            // 이번에 이동한 위치가 이동 가능한 위치가 아니면 짤
            // 이미 이동한 적이 있으면 짤
            // 목표지점에 달하면 break
            if (x == N - 1 && y == N - 1) {
                answer = Math.min(pos.price, answer);
                continue;
            }

            // 다음으로 이동할 위치를 큐에 넣어
            // 직전 위치가 null이거나 직전+지금+다음 위치의 x나 y가 모두 같으면 직진이고 아니면 커브길
            for (int i = 0; i < 4; i++) {
                int dx = x + moveX[i];
                int dy = y + moveY[i];
                int price = pos.price + (isCurved(pos, x, y, dx, dy) ? 600 : 100);

                if (dx < 0 || dy < 0 || dx >= N || dy >= N || isBlocked(board, dx, dy)) continue;
                if (visited[dy][dx] != 0 && visited[dy][dx] < price) continue;

                queue.add(new Position(dx, dy, price, pos));
                visited[dy][dx] = price;
            }
        }

        return answer;
    }

    private boolean isCurved(Position pos, int x, int y, int dx, int dy) {
        return (pos.before != null && (pos.before.x != x || x != dx) && (pos.before.y != y || y != dy));
    }

    private boolean isBlocked(int[][] board, int x, int y) {
        return board[y][x] == 1;
    }

    private class Position {
        int x;
        int y;
        int price;
        Position before;

        Position(int x, int y, int price, Position before) {
            this.x = x;
            this.y = y;
            this.price = price;
            this.before = before;
        }
    }
}
