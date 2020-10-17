package hacker_rank;

import java.util.Arrays;

public class Pairs {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 3, 4, 2};
        System.out.println(pairs(2, arr1));

        int[] arr2 = {1, 2, 3, 4};
        System.out.println(pairs(1, arr2));
    }

    static int pairs(int target, int[] arr) {
        int count = 0;
        Arrays.sort(arr);

        for (int p1 = 0; p1 < arr.length - 1; p1++) {
            for (int p2 = p1 + 1; p2 < arr.length; p2++) {
                if (arr[p2] - arr[p1] == target) count++;
                else if (arr[p2] - arr[p1] > target) break;
            }
        }

        return count;
    }
}
