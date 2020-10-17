package programmers;

public class Solution2 {
    // 상하좌우
    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;

    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[][] office = {{5, -1, 4}, {6, 3, -1}, {2, -1, 1}};
        String[] move = {"go", "go", "right", "go", "right", "go", "left", "go"};
        System.out.println(solution.solution(office, 1, 0, move));
    }

    public int solution(int[][] office, int r, int c, String[] move) {
        Cleaner cleaner = new Cleaner(office, r, c);
        for (String command : move) {
            if (command.equals("go")) {
                cleaner.go();
            } else {
                cleaner.turn(command);
            }
        }

        return cleaner.dust;
    }

    class Cleaner {
        int direction = UP;
        int dust = 0;
        int[][] office;
        int y;
        int x;

        public Cleaner(int[][] office, int y, int x) {
            this.office = office;
            this.y = y;
            this.x = x;
        }

        public void go() {
            int newX = this.x + dx[direction];
            int newY = this.y + dy[direction];

            if (newX == -1 || newY == -1 || newX >= office.length || newY >= office.length || office[newY][newX] == -1) {
                return;
            }

            this.x = newX;
            this.y = newY;
            this.dust += office[y][x];
            office[y][x] = 0;
        }

        public void turn(String dir) {
            if (dir.equals("right")) {
                turn(RIGHT, LEFT, UP, DOWN);
            } else if (dir.equals("left")) {
                turn(LEFT, RIGHT, DOWN, UP);
            }
        }

        private void turn(int d1, int d2, int d3, int d4) {
            switch (direction) {
                case UP:
                    direction = d1;
                    break;
                case DOWN:
                    direction = d2;
                    break;
                case LEFT:
                    direction = d3;
                    break;
                case RIGHT:
                    direction = d4;
                    break;
            }
        }
    }
}
