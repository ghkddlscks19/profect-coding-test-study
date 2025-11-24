import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < reserve.length; i++)
            set.add(reserve[i]);
        
        for(int i = 0; i < lost.length; i++) 
            if(set.contains(lost[i])){
                answer++;
                set.remove(lost[i]);
            }else 
                list.add(lost[i]);
                
        
        for(int i = 0; i < list.size(); i++) {
            int[] p = {-1, 1};
            int idx = 0;
            while(idx<= 1){
                int target = list.get(i) + p[idx];
                if(set.contains(target)){
                    answer++;
                    set.remove(target);
                    break;
                }
                idx++;
            }
            
            if(set.isEmpty())
                break;
        }
        return answer;
    }
}
