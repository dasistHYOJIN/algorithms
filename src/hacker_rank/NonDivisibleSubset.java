package hacker_rank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NonDivisibleSubset {
    public static void main(String[] args) {
        int[] a = {1, 7, 2, 4};
        System.out.println(nonDivisibleSubset(3, Arrays.stream(a).boxed().collect(Collectors.toList())));

    }

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.size() - 1; i++) {
            int one = s.get(i);
            for (int j = i + 1; j < s.size(); j++) {
                int two = s.get(j);
                if ((one + two) % k != 0) {
                    set.add(one);
                    set.add(two);
                }
            }
        }

        return set.size();
    }
}
