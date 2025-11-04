import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        
        for(int i=0; i<n; i++){
            String rotated = s.substring(i) + s.substring(0, i);
            
            if(isValid(rotated))
                answer++;
        }
        return answer;
    }
    
    private boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = Map.of(')', '(', ']', '[', '}', '{');
        
        for (char c : str.toCharArray()) {
            if (pairs.containsValue(c)) 
                stack.push(c);
            else if (pairs.containsKey(c)) { 
                if (stack.isEmpty() || stack.pop() != pairs.get(c))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
