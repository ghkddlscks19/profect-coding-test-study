import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<String> stack = new ArrayDeque<>();
        String[] arr = s.split("");
        
        for(String a : arr) {
            if(a.equals("("))
                stack.push(a);
            else
                if(!stack.isEmpty() && stack.peek().equals("("))
                    stack.pop();
                else {
                    answer = false;
                    break;
                }
        }
        
        if(!stack.isEmpty())
            answer = false;

        return answer;
    }
}
