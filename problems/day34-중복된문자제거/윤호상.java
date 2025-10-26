import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        if(my_string == null || my_string.isBlank())
            return my_string;
        
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        
        for(char c : my_string.toCharArray()){
            if(set.add(c))
                sb.append(c);
        }
        answer = sb.toString();
        return answer;
    }
}
