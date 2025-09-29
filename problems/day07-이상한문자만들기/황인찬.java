import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        // 단어 속 인덱스
        int idx = 0;
        
        for(int i =0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == ' ') {
                sb.append(c);
                idx = 0; // 공백 만나면 단어 속 인덱스 0으로 초기화
            } else {
                if(idx % 2 == 0) {
                    sb.append(Character.toUpperCase(c));
                }
                else {
                    sb.append(Character.toLowerCase(c));
                }
                
                idx++;
            }
            
        }
        
        return sb.toString();
    }
}
