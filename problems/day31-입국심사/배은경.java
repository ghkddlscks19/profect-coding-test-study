import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        int len = times.length;
        
        long left = 1;
        long right = (long)times[len - 1] * n;
        answer = right;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for(int i = 0; i < times.length; i++)
                cnt += mid / times[i];
            
            if(cnt >= n) {
                answer = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}
