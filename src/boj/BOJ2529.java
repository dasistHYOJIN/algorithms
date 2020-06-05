package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2529 {
    static Map<Integer, List<Integer>> biggerThan = initBiggerThan();
    static Map<Integer, List<Integer>> smallerThan = initSmallerThan();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        String input = br.readLine().replaceAll(" ", "");

        Set<Integer> startLefts = (input.charAt(0) == '<') ? biggerThan.keySet() : smallerThan.keySet();
        List<String> results = new ArrayList<>();
        for (int left : startLefts) {
            List<Integer> i = new ArrayList<>();
            i.add(left);
            greedy(results, i, input, left, 0);
        }

        Collections.sort(results);

        System.out.println(String.format("%s\n%s", results.get(results.size() - 1), results.get(0)));
    }

    private static void greedy(List<String> results, List<Integer> result, String input, int left, int symbolAt) {
        if (result.size() == input.length() + 1) {
            results.add(parseToString(result).toString());
            return;
        }

        List<Integer> values = (input.charAt(symbolAt) == '<') ? biggerThan.get(left) : smallerThan.get(left);

        if (values == null) return;

        for (int value : values) {
            if (result.contains(value)) continue;

            result.add(value);
            greedy(results, result, input, value, symbolAt + 1);
            result.remove(result.size() - 1);
        }
    }

    private static StringBuilder parseToString(final List<Integer> i) {
        StringBuilder result = new StringBuilder();
        for (int integer : i) {
            result.append(integer);
        }
        return result;
    }

    private static Map<Integer, List<Integer>> initBiggerThan() {
        Map<Integer, List<Integer>> biggerThan = new HashMap<>();

        for (int key = 0; key < 9; key++) {
            List<Integer> list = new ArrayList<>();
            for (int value = key + 1; value < 10; value++) {
                list.add(value);
            }
            biggerThan.put(key, list);
        }

        return biggerThan;
    }

    private static Map<Integer, List<Integer>> initSmallerThan() {
        Map<Integer, List<Integer>> smallerThan = new HashMap<>();

        for (int key = 1; key < 10; key++) {
            List<Integer> list = new ArrayList<>();
            for (int value = key - 1; value >= 0; value--) {
                list.add(value);
            }
            smallerThan.put(key, list);
        }

        return smallerThan;
    }
}
