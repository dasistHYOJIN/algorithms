package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LC0007 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(reverse(Integer.parseInt(br.readLine())));
    }

    public static int reverse(int x) {
        StringBuilder number = new StringBuilder(String.valueOf(x));

        boolean sign = number.charAt(0) == '-';

        if (sign) number.deleteCharAt(0);

        number.reverse();
        number.insert(0, sign ? "-" : "");

        try {
            return Integer.parseInt(number.toString());
        } catch (Exception e) {
            return 0;
        }
    }
}
