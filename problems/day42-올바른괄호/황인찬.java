import java.util.*;
class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(char c: s.toCharArray()) {
            if(c == '(') stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
