package test.kakao.intern;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_1 {
    private static int[] moveX = {1, 0, -1, 0};
    private static int[] moveY = {0, -1, 0, 1};

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();

        int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        System.out.println(solution.solution(numbers1, "right"));

        int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
//        System.out.println(solution.solution(numbers2, "left"));
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder result = new StringBuilder();

        Position left = new Position(0, 3, 0);
        Position right = new Position(2, 3, 0);

        for (int number : numbers) {
            int x = (number == 0) ? 1 : (number - 1) % 3;
            int y = (number == 0) ? 3 : (number - 1) / 3;

            if (number == 1 || number == 4 || number == 7) {
                result.append('L');
                setHandPosition(left, x, y);
            } else if (number == 3 || number == 6 || number == 9) {
                result.append('R');
                setHandPosition(right, x, y);
            } else {
                int leftCount = search(left, x, y);
                int rightCount = search(right, x, y);

                if (leftCount > rightCount || (leftCount == rightCount && hand.equals("right"))) {
                    result.append('R');
                    setHandPosition(right, x, y);
                } else if (leftCount < rightCount || hand.equals("left")) {
                    result.append('L');
                    setHandPosition(left, x, y);
                }
            }
        }

        return result.toString();
    }

    private void setHandPosition(Position position, int x, int y) {
        position.x = x;
        position.y = y;
    }

    private int search(Position position, int targetX, int targetY) {
        int count = 0;

        boolean[][] visited = new boolean[4][3];
        Queue<Position> queue = new LinkedList<>();
        queue.add(position);
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int x = pos.x;
            int y = pos.y;
            int c = pos.count;

            if (x == targetX && y == targetY) {
                count = c;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int dx = x + moveX[i];
                int dy = y + moveY[i];

                if (dx < 0 || dy < 0 || dx >= 3 || dy >= 4) continue;
                if (visited[dy][dx]) continue;

                queue.add(new Position(dx, dy, c + 1));
                visited[dy][dx] = true;
            }
        }

        return count;
    }

    private class Position {
        int x;
        int y;
        int count;

        Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
