import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        Set<Character> hs = new HashSet<>();
        
        // set에 스킬 추가
        for(char c: skill.toCharArray()) {
            hs.add(c);
        }
        
        int answer = 0;
        
        for(String sk: skill_trees) {
            if(isValid(sk, skill, hs)) answer++;
        }
        
        return answer;
    }
    
    boolean isValid(String sk, String skill, Set<Character> hs) {
        int idx = 0;
        for(char c: sk.toCharArray()) {
            if(hs.contains(c)) {
                if(skill.charAt(idx) != c) return false;
                idx++;
            }
        }
        
        return true;
    }
}
