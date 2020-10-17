package codility;

import java.util.Arrays;

public class Codility001 {
    public static void main(String[] args) {
        Codility001 c = new Codility001();

        int[] A = {9, 3, 9, 3, 9, 7, 9};

        System.out.println(c.solution(A));
    }

    public int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 0; i < A.length - 1; i += 2) {
            if (A[i] != A[i + 1]) {
                if (A[i + 1] == A[i + 2]) return A[i];
                return A[i + 1];
            }
        }

        return A[A.length - 1];
    }

}
