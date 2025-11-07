import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        
        int time = 0;
        int sum = 0;
        
        for(int truck : truck_weights){
            while(true){
                if(bridge.isEmpty()){
                    bridge.add(truck);
                    sum += truck;
                    time++;
                    break;
                }else if(bridge.size() == bridge_length){
                    sum -= bridge.poll();
                }else{
                    if(sum + truck <= weight){
                        bridge.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }else{
                        bridge.add(0);
                        time++;
                    }
                }
            }
        }
        answer = time + bridge_length;
        return answer;
    }
}
