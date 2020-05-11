package kakao.winter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Solution_2_3 {
    public static void main(String[] args) {
        Solution_2_3 solution = new Solution_2_3();

        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String s3 = "{{20,111},{111}}";
        String s4 = "{{123}}";
        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        System.out.println(Arrays.toString(solution.solution(s5)));

    }

    public int[] solution(String s) {
        String[] split = s.replace("{{", "").replace("}}", "").split("\\},\\{");
        Arrays.sort(split, Comparator.comparingInt(String::length));

        int[] answer = new int[split.length];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < split.length; i++) {
            for (String ss :split[i].split(",")) {
                if (set.add(ss)) answer[i] = Integer.parseInt(ss);
            }
        }

        return answer;
    }
}
