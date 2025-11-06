import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int n = progresses.length;
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            queue.offer(progresses[i]);
        }
        
        int idx = 0;
        int day = 1;
        while(!queue.isEmpty()) {
            int cnt = 0;
            while(!queue.isEmpty() && queue.peek() + (speeds[idx] * day)>= 100) {
                queue.poll();
                cnt++;
                idx++;
            }
            
            if(cnt > 0)
                list.add(cnt);
            day++;
        }
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) 
            answer[i] = list.get(i);
        
        return answer;
    }
}
