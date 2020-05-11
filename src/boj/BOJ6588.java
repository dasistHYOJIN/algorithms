package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        StringBuilder result = new StringBuilder();
        while (!(input = br.readLine()).equals("0")) {
            int n = Integer.parseInt(input);

            List<Integer> sosu = getSosu(n);
            boolean flag = false;
            for (int i = 0; i < sosu.size(); i++) {
                int m = n - sosu.get(i);
                if (flag = sosu.contains(m)) {
                    result.append(String.format("%d = %d + %d\n", n, sosu.get(i), m));
                    break;
                }
            }

            if (!flag) result.append("Goldbach's conjecture is wrong.");

        }

        System.out.println(result.toString());
    }

    private static List<Integer> getSosu(final int n) {
        boolean[] eratosthenes = eratosthenes(n);

        List<Integer> sosu = new ArrayList<>();
        for (int i = 2; i < eratosthenes.length; i++) {
            if (!eratosthenes[i]) sosu.add(i);
        }

        return sosu;
    }

    private static boolean[] eratosthenes(final int n) {
        boolean[] numbers = new boolean[n + 1];

        numbers[0] = true;
        numbers[1] = true;

        for (int i = 2; i < numbers.length; i++) {
            for (int j = 2; (i * j) < numbers.length; j++) {
                if (numbers[(i * j)]) break;
                numbers[(i * j)] = true;
            }
        }

        return numbers;
    }
}
