import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        //각자 배포 날짜 구하기
        int day[] = new int[n];
        
        for(int i =0; i<n; i++){
            day[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }  
        
        List<Integer> answer = new ArrayList<>();
        
        int cnt = 0;
        int maxDay = day[0];
        
        for(int i =0; i<n; i++) {
            if(day[i] <= maxDay) cnt++;
            else {
                answer.add(cnt);
                maxDay = day[i];
                cnt = 1;
            }
        }
        
        answer.add(cnt);
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
