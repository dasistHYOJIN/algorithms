package boj;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 불필요한 중복 탐색으로 메모리 초과
 */
public class BOJ6603 {
    private static Set<Set<Integer>> lottos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter results = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while (!(input = br.readLine()).equals("0")) {
            lottos = new HashSet<>();
            int[] numbers = initNumbers(input);

            int[] result = new int[6];
            boolean[] visited = new boolean[numbers.length];

            for (int i = 0; i <= numbers.length - 6; i++) {
                visited[i] = true;
                result[0] = numbers[i];
                search(numbers, result, visited, 1);
                visited[i] = false;
            }

            List<String> sortedLotto = new ArrayList<>();
            for (Set<Integer> lotto : lottos) {
                ArrayList<Integer> l = new ArrayList<>(lotto);
                Collections.sort(l);

                StringBuilder sb = new StringBuilder();
                for (int i : l) {
                    sb.append(i).append(" ");
                }
                sortedLotto.add(sb.toString().trim());
            }

            Collections.sort(sortedLotto);
            results.append(String.join("\n", sortedLotto)).append("\n\n");
        }

        results.flush();
        results.close();
    }

    private static void search(int[] numbers, int[] result, boolean[] visited, int count) {
        if (count == 6) {
            lottos.add(Arrays.stream(result).boxed().collect(Collectors.toSet()));
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (visited[i]) continue;

            result[count] = numbers[i];
            visited[i] = true;
            search(numbers, result, visited, count + 1);
            visited[i] = false;
        }
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
