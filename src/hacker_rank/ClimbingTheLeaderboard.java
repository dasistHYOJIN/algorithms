package hacker_rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClimbingTheLeaderboard {
    public static void main(String[] args) {
        int[] scores1 = {100, 90, 90, 80, 75, 60};
        int[] alice1 = {50, 65, 77, 90, 102};
        System.out.println(Arrays.toString(climbingLeaderboard(scores1, alice1)));

        int[] scores2 = {100, 100, 50, 40, 40, 20, 10};
        int[] alice2 = {5, 25, 50, 120};
        System.out.println(Arrays.toString(climbingLeaderboard(scores2, alice2)));
    }

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] result = new int[alice.length];

        List<Integer> ss = parseToList(scores);

        for (int a = 0; a < alice.length; a++) {
            // 인덱스를 찾아서
            int key = alice[a];
            int rank = searchIndex(key, ss);

            // 해당 인덱스에 삽입
            result[a] = rank + 1;
            if (!ss.contains(key)) {
                ss.add(rank, key);
            }
        }

        return result;
    }

    private static int searchIndex(int key, List<Integer> ss) {
        if (ss.get(0) <= key) return 0;
        if (ss.get(ss.size() - 1) > key) return ss.size();

//        return binarySearch(key, ss);
        return binarySearch(key, 0, ss.size() - 1, ss);
    }

    private static int binarySearch(int key, List<Integer> scores) {
        int start = 0;
        int end = scores.size() - 1;
        int pivot;

        while (start != end) {
            pivot = (start + end) / 2;

            if (scores.get(pivot) == key) {
                return pivot;
            } else if (key < scores.get(pivot)) {
                start = pivot + 1;
            } else {
                end = pivot;
            }
        }

        return (scores.get(start) > key) ? start + 1 : start;
    }

    private static int binarySearch(int key, int start, int end, List<Integer> scores) {
        if (start == end) {
            return (scores.get(start) > key) ? start + 1 : start;
        }

        int pivot = (start + end) / 2;

        if (scores.get(pivot) == key) {
            return pivot;
        } else if (key < scores.get(pivot)) {
            return binarySearch(key, pivot + 1, end, scores);
        } else {
            return binarySearch(key, start, pivot, scores);
        }
    }

    private static List<Integer> parseToList(int[] scores) {
        List<Integer> list = new ArrayList<>();
        for (int score : scores) {
            if (!list.contains(score)) {
                list.add(score);
            }
        }
        return list;
    }

    private static int searchIndex(int i, int key, List<Integer> scores) {
        if (i == scores.size()) {
            return scores.size();
        }
        if (scores.get(i) <= key) {
            return i;
        }

        return searchIndex(i + 1, key, scores);
    }
}
