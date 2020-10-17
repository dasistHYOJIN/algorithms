package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BOJ3190 {
    private static int[] moveX = {1, 0, -1, 0};
    private static int[] moveY = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int K = Integer.parseInt(br.readLine());
        // 보드 초기화
        boolean[][] board = putApples(br, N, K);

        int L = Integer.parseInt(br.readLine());
        Queue<Direction> directions = getDirections(br, L);

        // 뱀
        Deque<Position> snake = new LinkedList<>();
        snake.addLast(new Position(0, 0));

        // 이동방향
        int dirIndex = 0;
        int second = 0;
        while (second++ >= 0) {
            Position head = snake.peekFirst();
            int x = head.x;
            int y = head.y;

            // 벽 또는 자기자신의 몸과 부딪혔을 때
            if (x < 0 || x >= N || y < 0 || y >= N || isBombed(snake, head)) break;

            // 사과 먹기
            if (board[y][x]) {
                board[y][x] = false;
            } else {
                snake.pollLast();
            }

            if (!directions.isEmpty()) {
                Direction direction = directions.peek();
                if (direction.sec == second) {
                    dirIndex = nextDirection(dirIndex, direction.direction);
                    directions.poll();
                }
            }

            int newX = x + moveX[dirIndex];
            int newY = y + moveY[dirIndex];

            snake.addFirst(new Position(newX, newY));
        }

        System.out.println(second);
    }

    private static boolean isBombed(final Deque<Position> snake, final Position head) {
        long count = snake.stream()
                .filter(position -> position.equals(head))
                .count();
        return count > 1;
    }

    private static int nextDirection(int dirIndex, String lr) {
        dirIndex += (lr.equals("L")) ? 1 : -1;

        if (dirIndex < 0) return 3;
        else if (dirIndex > 3) return 0;
        return dirIndex;
    }

    private static Queue<Direction> getDirections(BufferedReader br, int l) throws IOException {
        Queue<Direction> directions = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            String[] input = br.readLine().split(" ");
            int sec = Integer.parseInt(input[0]);
            String direction = input[1];

            directions.add(new Direction(sec, direction));
        }

        return directions;
    }

    private static boolean[][] putApples(BufferedReader br, int n, int k) throws IOException {
        boolean[][] board = new boolean[n][n];

        // 사과 놓기
        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            int y = Integer.parseInt(input[0]) - 1;
            int x = Integer.parseInt(input[1]) - 1;

            board[y][x] = true;
        }

        return board;
    }

    private static class Direction {
        int sec;
        String direction;

        public Direction(int sec, String direction) {
            this.sec = sec;
            this.direction = direction;
        }
    }

    private static class Position {
        int x;
        int y;

        public Position(final int x, final int y) {
            this.x = x;
            this.y = y;
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
