import java.util.*;
class Solution {
    public int solution(String s) {
        int minLength = s.length(); // 압축하지 않은 경우
        
        // 압축을 1부터 문자열 길이의 절반까지 하기
        for (int i =1; i<=s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String base = s.substring(0, i); // 첫 번째 조각
            int count = 1;
            
            // 두 번째 조각부터 비교 시작
            for (int j =i; j<s.length(); j+=i) {
                String current = s.substring(j, Math.min(j+i, s.length()));
                
                if (base.equals(current) && current.length() == i) {
                    // 이전 조각과 같고, 길이도 i와 같은 경우 (완전한 조각)
                    count++;
                } else {
                    // 다른 조각이거나 마지막 불완전한 조각인 경우
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(base);
                    
                    base = current;
                    count = 1;
                }
            }
            
            // 마지막 조각 처리
            if (count > 1) {
                sb.append(count);
            }
            sb.append(base);
            
            // 최소 길이 업데이트
            minLength = Math.min(minLength, sb.length());
        }
        
        return minLength;
    }
}
