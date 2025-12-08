import java.util.*;

class Solution {
    public int solution(int[] ability, int number) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i = 0; i < ability.length; i++) {
            que.offer(ability[i]);
            answer += ability[i];
        }
    
        while(number > 0) {
            number--;
            int sum = que.poll() + que.poll();
            answer += sum;
            que.offer(sum);
            que.offer(sum);
        }
        
        return answer;
    }
}
