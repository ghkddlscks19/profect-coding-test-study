class Solution {
    boolean solution(String s) {
        boolean answer = true;    
            
        if (s.charAt(0) == ')')
            return false;

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                count++;
            else
                count--;
            
            if (count < 0)
                return false;
        }
        
        if (count != 0) 
            return false;
        
        return answer;
    }
}
