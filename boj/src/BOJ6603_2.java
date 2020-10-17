package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ6603_2 {
    private static List<String> lottos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter results = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while (!(input = br.readLine()).equals("0")) {
            int[] numbers = initNumbers(input);
            lottos = new ArrayList<>();
            String[] result = new String[6];

            for (int i = 0; i <= numbers.length - 6; i++) {
                boolean[][] visited = new boolean[numbers.length][numbers.length];

                visited[i][0] = visited[0][i] = true;
                result[0] = String.valueOf(numbers[i]);

                dfs(result, numbers, visited, i, 1);
            }

            results.append(String.join("\n", lottos)).append("\n\n");
        }

        results.flush();
        results.close();
    }

    private static void dfs(String[] result, int[] numbers, boolean[][] visited, int index, int count) {
        if (count == 6) {
            lottos.add(String.join(" ", result));
            return;
        }

        for (int i = index + 1; i < numbers.length; i++) {
            if (isVisited(visited, i)) continue;

            visited[i][index] = visited[index][i] = true;
            result[count] = String.valueOf(numbers[i]);

            dfs(result, numbers, visited, i, count + 1);

            visited[i][index] = visited[index][i] = false;
        }
    }

    private static boolean isVisited(boolean[][] visited, int i) {
        for (boolean v : visited[i]) {
            if (v) return true;
        }
        return false;
    }

    private static int[] initNumbers(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int[] numbers = new int[Integer.parseInt(st.nextToken())];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        return numbers;
    }
}
