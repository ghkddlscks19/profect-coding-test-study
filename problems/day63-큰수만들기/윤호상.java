import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            while (!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
         while (k > 0) {
            stack.pop();
            k--;
        }
        
        for (char c : stack) {
            sb.append(c);
        }

        answer = sb.toString();
        
        return answer;
    }
}
