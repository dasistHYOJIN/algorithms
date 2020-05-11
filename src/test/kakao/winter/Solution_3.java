package test.kakao.winter;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_3 {
    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();

        String[] user_id1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id1 = {"fr*d*", "abc1**"};

//        System.out.println(solution.solution(user_id1, banned_id1));

        String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id2 = {"fr*d*", "*rodo", "******", "******"};

        System.out.println(solution.solution(user_id2, banned_id2));

        String[] user_id3 = {"a", "b", "c", "d", "e", "f", "g", "h"};
        String[] banned_id3 = {"*", "*", "*", "*", "*", "*", "*", "*"};

//        System.out.println(solution.solution(user_id3, banned_id3));

        String[] user_id4 = {"a", "b", "c", "d", "e", "f", "g", "h"};
        String[] banned_id4 = {"*", "*", "*"};

//        System.out.println(solution.solution(user_id4, banned_id4));

        String[] user_id5 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id5 = {"*rodo", "*rodo", "******"};

//        System.out.println(solution.solution(user_id5, banned_id5));
    }

    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> lists = new ArrayList<>();
        for (String banned : banned_id) {
            lists.add(matchesUserId(banned, user_id));
        }

        System.out.println(lists);

        Set<List<String>> set = new HashSet<>();
        recursive(lists, 0, new String[lists.size()], set);
        System.out.println(set);

        return set.size();
    }

    private void recursive(List<List<String>> lists, int index, String[] permutation, Set<List<String>> set) {
        if (lists.size() == index) {
            List<String> collect = Arrays.stream(permutation).distinct().sorted().collect(Collectors.toList());
            if (collect.size() == lists.size())
                set.add(collect);
            return;
        }

        List<String> list = lists.get(index);
        for (String s : list) {
            permutation[index] = s;
            recursive(lists, index + 1, permutation, set);
        }
    }

    private List<String> matchesUserId(String banned, String[] user_id) {
        List<String> list = new ArrayList<>();

        String s = banned.replace("*", "\\w");
        for (String id : user_id) {
            if (id.matches(s)) list.add(id);
        }

        return list;
    }
}
