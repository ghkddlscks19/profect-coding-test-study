import java.util.*;
class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        int answer = 0;
        
        for(int i =0; i<s.length(); i++) {
            if(isValid(sb.toString())) answer++;
            // 앞에거를 뒤에 추가하고 앞에거를 삭제하며 회전
            sb.append(sb.charAt(0)); 
            sb.deleteCharAt(0);
        }
        return answer;
    }
    
    static boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(char c: s.toCharArray()) {
            if(stack.isEmpty()) stack.push(c);
            else if(c == ')' && stack.peek() == '(') stack.pop();
            else if(c == '}' && stack.peek() == '{') stack.pop();
            else if(c == ']' && stack.peek() == '[') stack.pop();
            else stack.push(c);
        }
        
        return stack.isEmpty();
    }
}
