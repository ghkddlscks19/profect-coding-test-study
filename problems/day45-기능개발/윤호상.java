import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        List<Integer> result = new ArrayList<>();
        int n = progresses.length;
        int[] days = new int[n];
        
        for(int i=0; i<progresses.length; i++){
            days[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
        }
        
        int base = days[0];
        int count = 1;
        
        for(int i=1; i<n; i++){
            if(days[i] <= base)
                count++;
            else{
                result.add(count);
                base = days[i];
                count = 1;
            }
        }
        result.add(count);
        answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
