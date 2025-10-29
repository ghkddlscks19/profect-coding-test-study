import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (String name : participant)
            hm.put(name, hm.getOrDefault(name, 0) + 1);
        
        for (String name : completion)
            hm.put(name, hm.get(name) - 1);
        
        for (String key : hm.keySet())
            if (hm.get(key) != 0)
                answer += key;
        
        return answer;
    }
}
