import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // Set 생성
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        
        for(int r: reserve) {
            resSet.add(r);
        }
        
        for(int l: lost) {
            // 여분이 있지만 도난당한 경우 제거
            if(resSet.contains(l)) resSet.remove(l);
            else lostSet.add(l);
        }
        
        // 여분을 기준으로 앞뒤 확인하고 체육복 빌려주기
        for(int r: resSet) {
            // 앞뒤 확인 후 빌려줄 수 있으면 빌려주고 set에서 제거
            if(lostSet.contains(r-1)) {
                lostSet.remove(r-1);
            } else if(lostSet.contains(r+1)) {
                lostSet.remove(r+1);
            }
        }
        
        int answer = n - lostSet.size();
        return answer;
    }
}
