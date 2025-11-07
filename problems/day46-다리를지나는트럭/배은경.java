import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int len = bridge_length;
        int cnt = 0;
        int w = 0;
        int num = len - 1;
        
        for(int i = 0; i < len; i++)
            que.offer(0);
        
        while(cnt < truck_weights.length) {
            w -= que.poll();;
            answer++;
           if(num + 1 <= len && w + truck_weights[cnt] <= weight) {
                int n = truck_weights[cnt++];
                w += n;
                que.offer(n);
            }else
               que.offer(0);
        }
        
        while(!que.isEmpty()) {
            answer++;
            que.poll();
        }
        
        return answer;
    }
}
