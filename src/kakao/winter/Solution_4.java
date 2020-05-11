package kakao.winter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_4 {
    public static void main(String[] args) {
        Solution_4 solution = new Solution_4();

        long k = 10;
//        long[] room_number = {1, 1, 1, 1, 1, 1};
//        long[] room_number = {1, 3, 4, 1, 3, 1};
        long[] room_number = {9, 8, 7, 6, 5, 2, 2, 1, 1, 1};
        System.out.println(Arrays.toString(solution.solution(k, room_number)));

    }

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        Set<Long> booked = new HashSet<>();

        for (int i = 0; i < room_number.length; i++) {
            long room = room_number[i];

            // 방이 이미 찼을 경우
            if (booked.contains(room)) {
                long pointer = room;
                while (booked.contains(pointer)) {
                    pointer++;
                }

                answer[i] = pointer;
            } else { // 비어있을 경우
                answer[i] = room;
            }

            booked.add(answer[i]);
        }

        return answer;
    }

}
