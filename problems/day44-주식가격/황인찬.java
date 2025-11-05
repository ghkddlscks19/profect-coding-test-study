import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        
        // 정답 배열을 현재 인덱스에서 끝까지의 거리로 초기화
        for(int i =0; i<len; i++) {
            answer[i] = len - i - 1;
        }
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // 0번째는 비교할 게 없음
        
        for(int i =1; i<len; i++) {
            // 비어있지 않고 가격이 떨어질 때
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int pop = stack.pop();
                answer[pop] = i - pop;
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}
