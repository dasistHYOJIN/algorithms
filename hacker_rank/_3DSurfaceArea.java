package hacker_rank;

public class _3DSurfaceArea {
    public static void main(String[] args) {
        int[][] A1 = {{1, 3, 4}, {2, 2, 3}, {1, 2, 4}};
        System.out.println(surfaceArea(A1));
        int[][] A2 = {{1}};
        System.out.println(surfaceArea(A2));

        int[][] A3 = {{51}, {32}, {28}, {49}, {28}, {21}, {98}, {56}, {99}, {77}};
        System.out.println(surfaceArea(A3));
    }

    static int surfaceArea(int[][] A) {
        int H = A.length;
        int W = A[0].length;

        int result = H * W * 2; // 위 아래

        // 앞뒤(가로)
        result += getFrontArea(A, H, W);

        // 좌우(세로)
        result += getSideArea(A, H, W);

        return result;
    }

    private static int getSideArea(int[][] A, int h, int w) {
        int side = 0;
        for (int y = 0; y < h; y++) {
            side += A[y][0];
            side += A[y][w - 1];

            for (int x = 0; x < w - 1; x++) {
                side += Math.abs(A[y][x] - A[y][x + 1]);
            }
        }
        return side;
    }

    private static int getFrontArea(int[][] A, int h, int w) {
        int front = 0;
        for (int x = 0; x < w; x++) {
            front += A[0][x];
            front += A[h - 1][x];

            for (int y = 0; y < h - 1; y++) {
                front += Math.abs(A[y][x] - A[y + 1][x]);
            }
        }
        return front;
    }
}
