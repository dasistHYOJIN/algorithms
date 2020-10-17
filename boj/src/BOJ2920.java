package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        Set<Boolean> result = new HashSet<>();

        for (int i = 0; i < 7; i++) {
            int i1 = Integer.parseInt(input[i]);
            int i2 = Integer.parseInt(input[i + 1]);

            result.add(isAscending(i1, i2));
        }

        if (result.size() > 1) System.out.println("mixed");
        else System.out.println(((boolean) result.toArray()[0]) ? "ascending" : "descending");
    }

    private static boolean isAscending(int i1, int i2) {
        return i1 < i2;
    }
}
