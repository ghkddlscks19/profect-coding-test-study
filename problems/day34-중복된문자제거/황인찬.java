import java.util.*;
class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        for(int i =0; i<my_string.length(); i++) {
            char c = my_string.charAt(i);
            if(!sb.toString().contains(String.valueOf(c))) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
