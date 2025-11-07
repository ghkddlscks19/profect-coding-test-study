import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int time = 0; // 시간
        int currWeight = 0; // 현재 무게
        int truckIdx = 0; // 트럭의 인덱스
        
        for(int i =0; i<bridge_length; i++) {
            q.offer(0); // 다리 길이만큼 일단 0으로 초기화
        }
        
        while(truckIdx < truck_weights.length) {
            time++; // 시간 증가
            
            // 다리에서 트럭이 빠져나감
            currWeight -= q.poll();
            
            // 다리를 건널 수 있는 조건일 때
            if(truck_weights[truckIdx] + currWeight <= weight) {
                q.offer(truck_weights[truckIdx]);
                currWeight += truck_weights[truckIdx];
                truckIdx++;
            } else {
                q.offer(0);
            }
        }
        
        // 마지막 트럭까지 건너는 시간은 결국 다리의 길이만큼임
        time += bridge_length;
        
        return time;
    }
}
