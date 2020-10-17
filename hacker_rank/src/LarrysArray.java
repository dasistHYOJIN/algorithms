package hacker_rank;

import java.util.Arrays;

public class LarrysArray {
    public static void main(String[] args) {
        int[] A1 = {1, 2, 3, 5, 4};
        int[] A2 = {1, 6, 5, 2, 4, 3};
        System.out.println(larrysArray(A1));
        System.out.println(larrysArray(A2));
        System.out.println(Arrays.toString(A1));
    }

    static String larrysArray(int[] A) {
        for (int baseIndex = 0; baseIndex < A.length - 2; baseIndex++) {
            // 해당 범위 중 가장 작은 값의 인덱스 찾기
            int minIndex = getMinIndex(A, baseIndex);

            // 최솟값이 baseIndex에 올 때까지 반복
            while (minIndex != baseIndex) {
                // minIndex가 가장 끝에 있을 경우에는 윈도우의 끝을 배열에 맞춘다
                rotate(A, (minIndex < A.length - 1) ? minIndex - 1 : minIndex - 2);
                minIndex -= 1;
            }
        }

        // 마지막 두 요소가 정렬이 올바르게 되어 있으면 YES, 아니면 NO
        return (A[A.length - 2] < A[A.length - 1]) ? "YES" : "NO";
    }

    private static void rotate(int[] A, int index) {
        int temp = A[index];
        A[index] = A[index + 1];
        A[index + 1] = A[index + 2];
        A[index + 2] = temp;
    }

    private static int getMinIndex(int[] A, int start) {
        int min = start;
        for (int i = start; i < A.length; i++) {
            min = (A[min] > A[i]) ? i : min;
        }
        return min;
    }
}
