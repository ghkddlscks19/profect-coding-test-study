import java.util.*;

class Solution {
    public int solution(int[] menu, int[] order, int k) {
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(menu[order[0]]);
        int time = 0;
        int max = 1;
        int idx = 1;
        int bf = 0;
        
        while(!que.isEmpty()) {
            if(time >= que.peek() + bf)
                bf = que.poll() + bf;
            if(que.isEmpty()) {
                time = idx * k;
                bf = time;
            }
            
            if(idx < order.length && time >= k * idx)
                que.offer(menu[order[idx++]]);
            if(que.size() > max)
                max = que.size();
            time++;
        }
        
        return max;
    }
}
