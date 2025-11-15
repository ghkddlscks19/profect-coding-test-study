import java.util.*;

class Solution {
    Map<Long, Long> roomMap = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            long want = room_number[i];
            answer[i] = find(want); // find로 실제 배정 방 찾기
        }

        return answer;
    }

    private long find(long room) {
        // 방이 비어있으면 배정 후 다음 방 번호로 연결
        if (!roomMap.containsKey(room)) {
            roomMap.put(room, room + 1); // 다음 후보 연결
            return room;
        }

        // 이미 차있으면 다음 방 탐색
        long next = find(roomMap.get(room)); // 재귀적으로 다음 방 찾기
        roomMap.put(room, next); // 경로 압축(캐싱)
        return next;
    }
}
