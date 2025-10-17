import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 정렬
        Arrays.sort(citations);
        
        int n = citations.length;
        for(int i =0; i<n; i++) {
            // 현재 위치부터 끝까지의 논문 갯수
            int h = n - i;
            
            // 현재 논문이 h번이상 인용 되었고 뒤의 논문도 h번 이상
            if(h <= citations[i]) return h;
        }
        
        return answer;
    }
}
