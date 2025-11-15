import java.util.*;

class Solution {
    Map<Long, Long> nextRoom = new HashMap<>();
    
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        for (int i = 0; i < room_number.length; i++) {
            answer[i] = checkIn(room_number[i]);
        }

        return answer;
    }
    
     private long checkIn(long room) {

        if (!nextRoom.containsKey(room)) {
            nextRoom.put(room, room + 1); 
            return room;
        }

        long next = checkIn(nextRoom.get(room));
        nextRoom.put(room, next);
        return next;
    }
}
