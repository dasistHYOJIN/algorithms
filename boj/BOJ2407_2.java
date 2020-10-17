package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ2407_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        BigInteger result = factorial(M + 1, N).divide(factorial(1, N - M));

        System.out.println(result);
    }

    private static BigInteger factorial(int start, int number) {
        BigInteger result = BigInteger.valueOf(1L);

        for (int i = start; i <= number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

}
