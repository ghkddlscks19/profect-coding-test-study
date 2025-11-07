import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> bridge = new LinkedList<>();
        
        for (int truck : truck_weights) {
            while(true) {
                answer++; 
                
                if (bridge.size() == bridge_length)
                    sum -= bridge.poll();
                if ((sum + truck) <= weight)  {
                    bridge.offer(truck);
                    sum += truck;
                    break;
                }
                else {
                    bridge.offer(0);
                }
            }
        }
        
        return answer + bridge_length;
    }
}
