import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
   
        for (int i = 0; i < my_string.length(); i++) {
            boolean is_equal = false;
            for (int j = 0; j < answer.length(); j++) {
                if (my_string.charAt(i) == answer.charAt(j)) {
                    is_equal = true;
                    break;
                }
            }
            
            if (is_equal == false) {
                answer += my_string.charAt(i);
            }
        }
        
        return answer;
    }
}
