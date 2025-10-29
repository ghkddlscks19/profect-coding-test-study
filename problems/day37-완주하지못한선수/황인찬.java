import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        // 완주자 넣기
        for(String c: completion) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        
        String answer = "";
        
        // 완주자 중에 참가자 있으면 빼버리기
        for(String p: participant) {
            if(hm.getOrDefault(p, 0) == 0) return p;
            else hm.put(p, hm.get(p) - 1);
        }
        
        return answer;
    }
}
