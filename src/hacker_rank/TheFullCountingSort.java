package hacker_rank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheFullCountingSort {
    public static void main(String[] args) {
        List<List<String>> arr = Arrays.asList(
                Arrays.asList("0", "ab"), Arrays.asList("6", "cd"), Arrays.asList("0", "ef"), Arrays.asList("6", "gh"),
                Arrays.asList("4", "ij"), Arrays.asList("0", "ab"), Arrays.asList("6", "cd"), Arrays.asList("0", "ef"),
                Arrays.asList("6", "gh"), Arrays.asList("0", "ij"), Arrays.asList("4", "that"), Arrays.asList("3", "be"),
                Arrays.asList("0", "to"), Arrays.asList("1", "be"), Arrays.asList("5", "question"), Arrays.asList("1", "or"),
                Arrays.asList("2", "not"), Arrays.asList("4", "is"), Arrays.asList("2", "to"), Arrays.asList("4", "the"));
        countSort2(arr);
    }

    // Complete the countSort function below.
    static void countSort(List<List<String>> arr) {
        Map<Integer, StringBuilder> result = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            List<String> array = arr.get(i);

            int index = Integer.parseInt(array.get(0));
            if (result.containsKey(index)) {
                result.get(index).append((i < arr.size() / 2) ? "-" : array.get(1)).append(" ");
            } else {
                result.put(index, new StringBuilder((i < arr.size() / 2) ? "-" : array.get(1)).append(" "));
            }
        }

        System.out.println(String.join("", result.values()).trim());
    }

    static void countSort2(List<List<String>> arr) {
        StringBuilder[] result = new StringBuilder[100];
        for (int i = 0; i < result.length; i++) {
            result[i] = new StringBuilder();
        }

        for (int i = 0; i < arr.size(); i++) {
            List<String> array = arr.get(i);

            int index = Integer.parseInt(array.get(0));
            result[index].append((i < arr.size() / 2) ? "-" : array.get(1)).append(" ");
        }

        System.out.println(String.join("", result).trim());
    }
}
