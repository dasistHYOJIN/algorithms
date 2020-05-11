package kakao.winter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_2 {
    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();

        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String s3 = "{{20,111},{111}}";
        String s4 = "{{123}}";
        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        System.out.println(Arrays.toString(solution.solution(s5)));

    }

    public int[] solution(String s) {
        // 배열로 파싱
        String[] split = s.replace("{{", "").replace("}}", "").split("\\},\\{");

        List<List<String>> collect = Arrays.stream(split).map(s1 -> s1.split(","))
                .sorted(Comparator.comparing(strings -> strings.length))
                .map(strings ->  new ArrayList<>(Arrays.asList(strings)))
                .collect(Collectors.toList());

        int[] answer = new int[collect.size()];

        for (int i = 0; i < collect.size(); i++) {
            List<String> tuple = collect.get(i);

            for (int j = 0; j < tuple.size(); j++) {
                String element = tuple.get(j);

                for (List<String> strings : collect) {
                    strings.remove(element);
                }

                answer[i] = Integer.parseInt(element);
            }

        }
        System.out.println(collect);

        return answer;
    }
}
