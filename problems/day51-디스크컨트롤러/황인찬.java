import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        // 요청 순 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        // 작업 시간 순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int currTime = 0;
        int totalTime = 0;
        int idx = 0;
        int cnt = 0;
        
        while(cnt < jobs.length) {
            // 현재 시간까지 요청된 작업들을 우선순위 큐에 추가
            while(idx < jobs.length && jobs[idx][0] <= currTime) {
                pq.offer(jobs[idx++]);
            }
            
            // 처리할 작업이 없으면 다음 작업 실행
            if(pq.isEmpty()) {
                currTime = jobs[idx][0];
            } else {
                int[] job = pq.poll();
                currTime += job[1]; // 작업 완료 시간 추가
                totalTime += currTime - job[0]; // 완료 시간 - 시작 시간
                cnt++;
            }
        }
        
        return totalTime / jobs.length;
    }
    
}
