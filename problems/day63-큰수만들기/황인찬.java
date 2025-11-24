import java.util.*;
class Solution {
    public String solution(String number, int k) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i =0; i<number.length(); i++) {
            char curr = number.charAt(i);
            
            // 스택이 비어있지 않고 현재 값이 스택에 있는 값보다 크고 k보다 카운트가 작으면 pop
            while(!stack.isEmpty() && stack.peek() < curr && cnt < k) {
                stack.pop();
                cnt++;
            }
            
            stack.push(curr);
        }
        
        // 역순인 경우라 pop이 k만큼 안된경우
        while(cnt < k) {
            stack.pop();
            cnt++;
        }
        
        for(char c: stack) {
            sb.append(c - '0');
        }
        
        
        return sb.reverse().toString();
    }
}
