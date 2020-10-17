package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        boolean[][] arr = initArr(br, N, M);

        StringBuilder result = new StringBuilder();

        doDfs(arr, new boolean[N], result, V - 1);
        result.append("\n");
        doBfs(arr, new boolean[N], result, V - 1);

        System.out.println(result.toString());
    }

    private static void doBfs(boolean[][] arr, boolean[] visited, StringBuilder result, int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int i = queue.poll();

            result.append(i + 1).append(" ");

            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] && !visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }

    private static void doDfs(boolean[][] arr, boolean[] visited, StringBuilder result, int v) {
        visited[v] = true;
        result.append(v + 1).append(" ");

        for (int i = 0; i < arr.length; i++) {
            if (arr[v][i] && !visited[i]) {
                doDfs(arr, visited, result, i);
            }
        }
    }

    private static boolean[][] initArr(BufferedReader br, int n, int m) throws IOException {
        boolean[][] arr = new boolean[n][n];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int src = Integer.parseInt(st.nextToken()) - 1;
            int dest = Integer.parseInt(st.nextToken()) - 1;

            arr[src][dest] = true;
            arr[dest][src] = true;
        }

        return arr;
    }
}
