class Solution {
    public long solution(int n, int[] times) {
        long start = 1;
        long end = (long) times[times.length - 1] * (long) n; // 최대 시간 * n이 최대값
        
        long answer = end;
        
        while(start <= end) {
            long mid = (start + end) / 2;
            
            // mid 시간 동안 n명이 할 수 있는지 확인
            long cnt = 0;
            for(int time: times) {
                cnt += mid / time;
                
                if(cnt >= n) break;
            }
            
            
            if(cnt >= n) {
                // n명 이상 처리가 가능하므로 end 줄이기
                answer = mid;
                end = mid - 1;
            } else {
                // n명 처리가 안되면 start를 늘리기
                start = mid + 1;
            }
        }
        
        return answer;
    }
}
