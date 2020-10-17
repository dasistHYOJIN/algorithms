package hacker_rank;

import java.math.BigInteger;

public class ExtraLongFactorials {
    public static void main(String[] args) {

        extraLongFactorials(100);
    }

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        BigInteger result = BigInteger.ONE;

        while (n > 0) {
            result = result.multiply(BigInteger.valueOf(n--));
        }

        System.out.println(result);
    }

}
