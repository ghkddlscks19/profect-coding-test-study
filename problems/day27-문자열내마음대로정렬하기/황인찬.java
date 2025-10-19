import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        // 우선순위 큐 이용해서 큰거부터 빼내면 될듯
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> {
            // n번째 문자가 같으면 오름차순으로
            if(s1.charAt(n) == s2.charAt(n)) {
                return s1.compareTo(s2);
            }
            
            // n번째 글자 기준으로 오름차순 정렬
            return s1.charAt(n) - s2.charAt(n);
        });
        
        for(String s: strings) {
            pq.offer(s);
        }
        
        String[] answer = new String[strings.length];
        
        int idx = 0;
        
        while(!pq.isEmpty()) {
            answer[idx++] = pq.poll();
        }
        
        return answer;
    }
}
