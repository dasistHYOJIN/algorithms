package test.kakao.winter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_4_2 {

    public static void main(String[] args) {
        Solution_4_2 solution = new Solution_4_2();

        long k = 10;
        long[] room_number = {1, 1, 1, 1, 1, 1};
//        long[] room_number = {1, 3, 4, 1, 3, 1};
//        long[] room_number = {9, 8, 7, 6, 5, 2, 2, 1, 1, 1};
        System.out.println(Arrays.toString(solution.solution(k, room_number)));

    }

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        Map<Long, Long> nextRooms = new HashMap<>();

        for (int i = 0; i < room_number.length; i++) {
            long bookedRoom = findRoom(nextRooms, room_number[i]);
            answer[i] = bookedRoom;
        }

        return answer;
    }

    private long findRoom(Map<Long, Long> nextRooms, long roomNumber) {
        // nextRooms에 이미 방이 있으면 다음 방을 찾아 재귀
        // 없으면 nextRooms에 넣고 answer에 넣기
        if (!nextRooms.containsKey(roomNumber)) {
            nextRooms.put(roomNumber, nextRooms.getOrDefault(roomNumber + 1, roomNumber + 1));
            return roomNumber;
        }

//        long nextRoom = findRoom(nextRooms, roomNumber + 1); // 여기가 문제!!
        long nextRoom = findRoom(nextRooms, nextRooms.get(roomNumber));
        nextRooms.put(roomNumber, nextRoom);

        return nextRoom;
    }

}
