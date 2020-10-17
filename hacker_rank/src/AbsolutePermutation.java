package hacker_rank;

import java.util.Arrays;

public class AbsolutePermutation {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(absolutePermutation(2, 1)));
        System.out.println(Arrays.toString(absolutePermutation(3, 0)));
        System.out.println(Arrays.toString(absolutePermutation(3, 2)));
//        System.out.println(Arrays.toString(absolutePermutation(5, 3)));
//        System.out.println(Arrays.toString(absolutePermutation(327,0)));
//        System.out.println(Arrays.toString(absolutePermutation(16, 8)));
//        System.out.println(Arrays.toString(absolutePermutation(297, 191)));
//        System.out.println(Arrays.toString(absolutePermutation(274, 29)));
//        System.out.println(Arrays.toString(absolutePermutation(958, 30)));
        System.out.println(Arrays.toString(absolutePermutation(100, 2)));
//        System.out.println(Arrays.toString(absolutePermutation(775, 0)));
//        System.out.println(Arrays.toString(absolutePermutation(770, 380)));
//        System.out.println(Arrays.toString(absolutePermutation(233, 118)));
//        System.out.println(Arrays.toString(absolutePermutation(770, 0)));
    }

    static int[] absolutePermutation(int n, int k) {
        int[] pos = new int[n];

        if (k == 0) {
            for (int i = 0; i < n; i++) {
                pos[i] = i + 1;
            }
        } else if (n % (k * 2) == 0) {
            for (int i = 0; i < n; i++) {
                int index = i + 1;
                pos[i] = index + ((i / k) % 2 == 0 ? k : -k);
            }
        } else {
            return new int[]{-1};
        }

        return pos;
    }
}
