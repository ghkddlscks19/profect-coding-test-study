import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<int[]> stack = new ArrayDeque<>();
        
        for(int i = 0; i < prices.length; i++) {
            int[] arr = new int[2];
            arr[0] = i;
            arr[1] = prices[i];
            
            while(!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                int a = stack.pop()[0];
                answer[a] = i - a;
            }
            stack.push(arr);
        }
        
        while(!stack.isEmpty()) {
            int a = stack.pop()[0];
            answer[a] = prices.length - 1 - a;
        }
        return answer;
    }
}
