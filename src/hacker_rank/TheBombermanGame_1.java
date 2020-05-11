package hacker_rank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheBombermanGame_1 {
    // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        String[] grid1 = {
                ".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO....."};
        System.out.println(Arrays.toString(bomberMan(3, grid1)));
        String[] grid2 = {
                ".......",
                "...O.O.",
                "....O..",
                "..O....",
                "OO...OO",
                "OO.O..."};
        System.out.println(Arrays.toString(bomberMan(5, grid2)));
    }

    static String[] bomberMan(int n, String[] grid) {
        // 보드 초기화
        int width = grid[0].length();
        int height = grid.length;

        int[][] board = new int[height][width];
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                board[h][w] = (grid[h].charAt(w) == 'O') ? 1 : 0;
            }
        }

        while (n-- > 0) {
//        for (int N = 0; N < n; N++) {
            System.out.println("==================");
            System.out.println(n + "초");

            for (int h = 0; h < height; h++) {
                System.out.println(Arrays.toString(board[h]));
            }

            Queue<Position> bombs = new LinkedList<>();

            // 전체 탐색하면서 1초씩 추가
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    board[h][w]++;
                    if (board[h][w] >= 4) {
                        bombs.add(new Position(h, w));
                        board[h][w] = 0;
                    }
                }
            }

            // 0이면 터뜨리지 않고 넘어가기
            while (!bombs.isEmpty()) {
                Position bomb = bombs.poll();
                for (int i = 0; i < 4; i++) {
                    int moveX = bomb.x + dx[i];
                    int moveY = bomb.y + dy[i];

                    if (moveX < 0 || moveY < 0 || moveX >= width || moveY >= height) continue;

                    board[moveY][moveX] = 0;
                }
            }

        }

        StringBuilder result = new StringBuilder();
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                result.append((board[h][w] > 0) ? 'O' : '.');
            }
            result.append("\n");
        }

        System.out.println(result.toString());
        return result.toString().split("\n");
    }

    static class Position {
        int y;
        int x;

        Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
