package test.kakao.winter;

import java.util.HashSet;
import java.util.Set;

public class Solution_3_2 {
    Set<Integer> set;

    public static void main(String[] args) {
        Solution_3_2 solution = new Solution_3_2();

        String[] user_id1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id1 = {"fr*d*", "abc1**"};

        System.out.println(solution.solution(user_id1, banned_id1));

        String[] user_id5 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id5 = {"*rodo", "*rodo", "******"};

//        System.out.println(solution.solution(user_id5, banned_id5));
    }

    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();

        go(0, user_id, banned_id, 0);

        return set.size();
    }

    private void go(int index, String[] user_id, String[] banned_id, int bit) {
        if (index == banned_id.length) {
            set.add(bit);
            return;
        }

        String reg = banned_id[index].replace("*", "[\\w\\d]");
        for (int i = 0; i < user_id.length; ++i) {
            System.out.println(String.format("bit: %s, i: %d, (bit >> i): %s", Integer.toBinaryString(bit), i, Integer.toBinaryString(bit >> i)));
            if ((((bit >> i) & 1) == 1) || !user_id[i].matches(reg)) continue;
            go(index + 1, user_id, banned_id, (bit | 1 << i));
        }

    }
}
