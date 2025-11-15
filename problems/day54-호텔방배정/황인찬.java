import java.util.*;
class Solution {
    HashMap<Long, Long> parent = new HashMap<>();
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        for(int i =0; i<room_number.length; i++) {
            answer[i] = find(room_number[i]);
        }
        return answer;
    }
    
    // 새로운 방 찾기 + 경로 압축
    long find(long room) {
        // 방이 비어있으면 방 배정
        if(!parent.containsKey(room)) {
            parent.put(room, room + 1);
            return room;
        }
        
        // 방이 차있으면 다음 빈 방 찾기
        long emptyRoom = find(parent.get(room));
        parent.put(room, emptyRoom + 1);
        return emptyRoom;
    }
}
