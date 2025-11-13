import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        // 보석 종류 개수 확인을 위함
        HashSet<String> hs = new HashSet<>(Arrays.asList(gems));
        int type = hs.size(); 
        
        // 어떤 보석이 몇번 나왔는지 저장
        HashMap<String, Integer> hm = new HashMap<>();
        
        int left = 0; // 왼쪽 포인터
        int minLen = Integer.MAX_VALUE; // 최소 길이
        int[] answer = new int[2];
        
        for(int right = 0; right<gems.length; right++) {
            // 오른쪽 보석 추가
            hm.put(gems[right], hm.getOrDefault(gems[right], 0) + 1);
            
            // 모든 종류의 보석을 다 가지고 있으면 왼쪽 포인터 이동
            while(type == hm.size()) {
                // 길이 갱신
                if(right - left < minLen) {
                    minLen = right - left;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }
                
                // 왼쪽 보석 제거
                hm.put(gems[left], hm.get(gems[left]) - 1);
                if(hm.get(gems[left]) == 0) hm.remove(gems[left]);
                left++;
            }
        }
        
        return answer;
        
    }
}
