import java.util.*;

class Solution {
    Map<Long, Long> parent = new HashMap<>();
    long find(long num) {
        if(!parent.containsKey(num)) {
            parent.put(num, num);
            return num;
        }
        
        long next = find(parent.get(num));
        parent.put(num, next);
        return next;
    }

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) { 
            answer[i] = find(room_number[i]); 
            parent.put(answer[i], answer[i] + 1);
        }

        return answer;
    }
}
