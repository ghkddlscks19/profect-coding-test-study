import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        ArrayDeque<Character> stack;
        char[] c = s.toCharArray();
        
        for(int i = 0; i < c.length; i++) {
            stack = new ArrayDeque<>();
            boolean checked = true;
            int idx = i;
            int cnt = 0;
            
            while(checked) {   
                if(cnt == c.length)
                    break;
                if(c[idx] == '(' || c[idx] == '[' || c[idx] == '{')
                    stack.push(c[idx]);
                else {
                    if(stack.isEmpty())
                        checked = false;
                    else {
                        char a = stack.pop();
                        if((c[idx] == ')' && a != '(') || (c[idx] == ']' && a != '[') || (c[idx] == '}' && a != '{'))
                            checked=false;
                    }
                }
                idx = (idx + 1) % c.length;
                cnt++;
            }
            
            if(stack.isEmpty() && checked == true)
                answer++;
        }
        return answer;
    }
}
