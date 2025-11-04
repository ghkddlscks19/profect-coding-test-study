import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Queue<Character> queue = new LinkedList<>();
        
        for (char c : s.toCharArray())
            queue.add(c);
        
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (char c : queue) {
                sb.append(c);
            }

            String result = sb.toString();
            if (isRight(result))
                answer++;
            
            char qChar = queue.poll();
            queue.add(qChar);
        }
        
        return answer;
    }
    
    public boolean isRight(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
            }
        }
       
        if (!stack.isEmpty())
            return false;
        
        return true;
    }
}
