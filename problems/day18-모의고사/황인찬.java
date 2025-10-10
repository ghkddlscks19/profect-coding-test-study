import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        
        for(int i =0; i<answers.length; i++) {
            if(student1[i % student1.length] == answers[i]) {
                cnt1++;
            }
            
            if(student2[i % student2.length] == answers[i]) {
                cnt2++;
            }
            
            if(student3[i % student3.length] == answers[i]) {
                cnt3++;
            }
        }
        
        List<Integer> answer = new ArrayList<>(); // 정답 넣을 리스트
        int max = Math.max(cnt1, Math.max(cnt2, cnt3)); // 최댓값 찾기
        
        if(cnt1 == max) answer.add(1);
        if(cnt2 == max) answer.add(2);
        if(cnt3 == max) answer.add(3);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
