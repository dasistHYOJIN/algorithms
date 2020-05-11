package test.kakao.winter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_1 {
    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();

        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
//        System.out.println(solution.solution(board, moves));

        int[][] board1 = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1}};
        int[] moves1 = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution.solution(board1, moves1));
    }

    public int solution(int[][] board, int[] moves) {
        List<Stack<Integer>> machine = initMachine(board);
        Stack<Integer> box = new Stack<>();

        int count = 0;
        for (int move : moves) {
            count += dropDoll(machine, box, move - 1);
        }

        return count;
    }

    private List<Stack<Integer>> initMachine(final int[][] board) {
        List<Stack<Integer>> machine = new ArrayList<>();

        for (int w = 0; w < board[0].length; w++) {
            Stack<Integer> line = new Stack<>();
            for (int h = board.length - 1; h >= 0; h--) {
                if (board[h][w] == 0) break;
                line.push(board[h][w]);
            }
            machine.add(line);
        }

        return machine;
    }

    private int dropDoll(List<Stack<Integer>> machine, Stack<Integer> box, int move) {
        if (machine.get(move).isEmpty()) return 0;
        if (box.isEmpty()) {
            box.push(machine.get(move).pop());
            return 0;
        }

        int peek = machine.get(move).pop();
        int doll = box.peek();

        if (peek == doll){
            box.pop();
            return 2;
        }

        box.push(peek);
        return 0;
    }
}
