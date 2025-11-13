import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        
        // 보석 종류 중복 제거
        Set<String> gemKinds = new HashSet<>(Arrays.asList(gems));
        int totalKinds = gemKinds.size();
        
        // 구간 내에 보석이 모두 존재하는지
        Map<String, Integer> map = new HashMap<>();
        
        int left = 0;
        int right = 0;
        
        int minLength = 100000;
        int answerLeft = 0;
        int answerRight = 0;
        
        while(true){
            if(map.size() == totalKinds){ 
                if(right - left < minLength){
                    minLength = right - left;
                    answerLeft = left + 1;
                    answerRight = right;
                }
                
                String leftGem = gems[left];
                map.put(leftGem, map.get(leftGem) - 1);
                // 보석이 0개가 됐으면 제거 -> totalKinds
                if (map.get(leftGem) == 0) 
                    map.remove(leftGem);
                left++;
                
            }else if(right == gems.length){
                break;
            }else{
                String rightGem = gems[right];
                map.put(rightGem, map.getOrDefault(rightGem, 0) + 1);
                right++;
            }
        }
        answer = new int[]{answerLeft, answerRight};
        
        return answer;
    }
}
