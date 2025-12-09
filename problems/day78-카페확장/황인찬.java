import java.util.*;
class Solution {
    public int solution(int[] menu, int[] order, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int max = 0;
        int freeTime = 0; // 바리스타가 커피 제조가 가능한 시간
        
        for(int i =0; i<order.length; i++) {
            int arriveTime = i * k; // 손님 도착 시간
            int menuTime = menu[order[i]]; // 메뉴 제조 시간
            
            // 도착 시각 이전에 완료된 손님 큐에서 제거
            while(!q.isEmpty() && q.peek() <= arriveTime) {
                q.poll();
            }
            
            // 현재 손님 커피 제조
            int startTime = Math.max(arriveTime, freeTime);
            
            // 커피 제조 완료
            int endTime = startTime + menuTime;
            
            // 큐에 추가
            q.offer(endTime);
            
            // 커피 제조 가능 시간 갱신
            freeTime = endTime;
            
            max = Math.max(max, q.size());
        }
    
        
        return max;
    }
}
