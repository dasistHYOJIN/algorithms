package hacker_rank;

import java.util.Arrays;

public class OrganizingContainersOfBalls {

    public static void main(String[] args) {
        int[][] container1 = {{1, 3, 1}, {2, 1, 2}, {3, 3, 3}};
        int[][] container2 = {{0, 2, 1}, {1, 1, 1}, {2, 0, 0}};
        int[][] container3 = {
                {997612619, 934920795, 998879231, 999926463}, {960369681, 997828120, 999792735, 979622676},
                {999013654, 998634077, 997988323, 958769423}, {997409523, 999301350, 940952923, 993020546}};

        System.out.println(organizingContainers(container1));
        System.out.println(organizingContainers(container2));
        System.out.println(organizingContainers(container3));

//        System.out.println(organizingContainers2(container1));
//        System.out.println(organizingContainers2(container2));
    }

    // Complete the organizingContainers function below.
    static String organizingContainers2(int[][] container) {
        int n = container.length;

        // 각각의 숫자 갯수 총합 세기
        int[] ballCounts = new int[n];
        int[] containerCounts = new int[n];

        for (int c = 0; c < n; c++) {
            for (int b = 0; b < n; b++) {
                ballCounts[b] += container[c][b];
                containerCounts[c] += container[c][b];
            }
        }

        Arrays.sort(ballCounts);
        Arrays.sort(containerCounts);

        return Arrays.equals(ballCounts, containerCounts) ? "Possible" : "Impossible";
    }

    static String organizingContainers(int[][] container) {
        // 각각의 숫자 갯수 총합 세기
        int[] ballCount = totalBallCounts(container);

        // 각 컨테이너의 총합에서 해당 공을 뺀 스왑 가능 수 카운트
        for (int c = 0; c < container.length; c++) {
            ballCount[c] -= container[c][c];
        }

        System.out.println(Arrays.toString(ballCount));

        // 카운트한 값이 컨테이너가 갖고 있는 다른 숫자의 공 갯수만큼이면 POSSIBLE
        for (int c = 0; c < container.length; c++) {
            for (int d = 0; d < container[c].length; d++) {
                if (c == d) continue;
                ballCount[c] -= container[c][d];
            }
        }

        System.out.println(Arrays.toString(ballCount));

        int result = 0;
        for (int count : ballCount) {
            result += count;
        }

        return result == 0 ? "Possible" : "Impossible";
    }

    private static int[] totalBallCounts(final int[][] container) {
        int[] ballCount = new int[container.length];
        for (int[] counts : container) {
            for (int c = 0; c < counts.length; c++) {
                ballCount[c] += counts[c];
            }
        }
        return ballCount;
    }
}
