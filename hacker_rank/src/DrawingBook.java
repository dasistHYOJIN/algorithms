package hacker_rank;

public class DrawingBook {
    public static void main(String[] args) {
        System.out.println(pageCount(7, 2));
        System.out.println(pageCount(5, 4));
    }

    static int pageCount(int n, int p) {
        return Math.min(p / 2, n / 2 - p / 2);
    }
}
