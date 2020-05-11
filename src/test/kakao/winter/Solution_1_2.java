package test.kakao.winter;

import java.util.Stack;

public class Solution_1_2 {
    public static void main(String[] args) {
        Solution_1_2 solution = new Solution_1_2();

        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution.solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        int count = 0;
        Stack<Integer> basket = new Stack<>();
        for (int move : moves) {
            int y = 0;
            while (board.length > y && board[y][move - 1] == 0) {
                y++;
            }

            count += (board.length > y) ? dropDoll(basket, board, y, move - 1) : 0;
        }

        return count;
    }

    private int dropDoll(Stack<Integer> basket, int[][] board, int y, int x) {
        int doll = board[y][x];
        board[y][x] = 0;

        if (!basket.isEmpty() && basket.peek() == doll) {
            basket.pop();
            return 2;
        }

        basket.push(doll);
        return 0;
    }
}
