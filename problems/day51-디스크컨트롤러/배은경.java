import java.util.*;

class Solution {
    public class Job {
        int num, req, time;
        
        public Job(int num, int req, int time){
            this.num = num;
            this.req = req;
            this.time = time;
        }
    }
  
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (a, b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        
        PriorityQueue<Job> queue = new PriorityQueue<>((a, b) -> {
            if(a.time == b.time)
                if(a.req == b.req)
                    return a.num - b.num;
                else
                    return a.req - b.req;
            return a.time - b.time;
        });
        queue.offer(new Job(0, jobs[0][0], jobs[0][1]));
        
        int idx = 1;
        int time = jobs[0][0];
        int len = jobs.length;
        while(!queue.isEmpty() || idx < len) {
            while(idx < len && jobs[idx][0] <= time){
                queue.offer(new Job(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            if(!queue.isEmpty()) {
                Job job = queue.poll();
                time += job.time;
                answer += time - job.req;
            }else 
                time = jobs[idx][0];
        }
        
        answer /= len;
        return answer;
    }
}
