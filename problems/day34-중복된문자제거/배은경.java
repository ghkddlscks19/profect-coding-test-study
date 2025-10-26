import java.util.*;

class Solution {
    public String solution(String my_string) {
        Set<String> set = new HashSet<>();
        String[] s = my_string.split("");
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length; i++) {
            if(!set.contains(s[i])){
                set.add(s[i]);
                sb.append(s[i]);
            }
        }
        
        return sb.toString();
    }
}
