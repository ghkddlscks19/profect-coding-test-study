import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        // 요청 시각 기준 정렬
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[1] == b[1])
                return a[0] - b[0]; // 소요시간 같으면 요청 시각 빠른순
            return a[1] - b[1];     // 소요시간 짧은 순
        });
           
        int time = 0;
        int idx = 0;    
        int total = 0;
        int count = jobs.length;
        
        while(idx < count || !pq.isEmpty()){

            // 현재 시간까지 요청된 작업 큐에 삽임
            while(idx < count && jobs[idx][0] <= time)
                pq.offer(jobs[idx++]);

            // 처리 가능한 작업 있으면 우선순위 순으로 처리
            if(!pq.isEmpty()){
                int[] job = pq.poll();
                time += job[1];
                total += (time - job[0]);
            }else
                // 요청된 작업 없으면 다음 작업 요청
                time = jobs[idx][0];
        }
        answer = total / count;
        return answer;
    }
}
