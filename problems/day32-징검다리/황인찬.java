import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks); // 바위 정렬
        // 이분탐색
        int left = 1;
        int right = distance;
        int answer = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(canRemove(distance, rocks, n, mid)) {
                // 제거할 수 있으면 더 큰 거리 탐색
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    static boolean canRemove(int distance, int[] rocks, int n, int minDist) {
        int count = 0;
        int prev = 0; // 이전 바위
        
        for(int rock: rocks) {
            if(rock - prev < minDist) {
                count++;
            } else {
                prev = rock;
            }
        }
        
        // 마지막 바위 체크
        if(distance - prev < minDist) count++;
        
        return count <= n;
    }
}
