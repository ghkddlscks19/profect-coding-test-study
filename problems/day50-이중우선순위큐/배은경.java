import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        int n;
        for(String s : operations) {
            if(s.startsWith("I")) {
                n = Integer.valueOf(s.substring(2));
                minQ.offer(n);
                maxQ.offer(n);
            }else if (s.substring(0, 3).equals("D -") && !minQ.isEmpty()) {
                n = minQ.poll();
                maxQ.remove(n);
            }else if(!minQ.isEmpty()){
                n = maxQ.poll();
                minQ.remove(n);
            }
        }
        
        if(!minQ.isEmpty()) {
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }
        return answer;
    }
}
