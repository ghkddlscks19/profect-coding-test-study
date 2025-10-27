import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c: before.toCharArray())
            if(!map.containsKey(c)) 
                map.put(c, 1);
            else 
                map.put(c, map.get(c) + 1);
        
        for(char c: after.toCharArray())
             if(!map.containsKey(c) || map.get(c) <= 0) {
                 answer = 0;
                 break;
             }else if(map.get(c) > 0) {
                 map.put(c, map.get(c) - 1);
             }
    
        return answer;
    }
}
