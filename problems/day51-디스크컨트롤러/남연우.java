import java.util.*;

class Job {
    int s;
    int l;
    int idx;
    
    Job(int s, int l, int idx) {
        this.s = s;
        this.l = l;
        this.idx = idx;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0;
        int time = 0;
        int i = 0;
        
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
            
        PriorityQueue<Job> heap = new PriorityQueue<>((a, b) -> {
            if(a.l != b.l) return a.l - b.l;
            if(a.s != b.s) return a.s - b.s;
            return a.idx - b.idx;
        });
        
        while (count < jobs.length) {
            while (i < jobs.length && jobs[i][0] <= time) {
                heap.add(new Job(jobs[i][0], jobs[i][1], i));
                i++;
            }
            
            if (!heap.isEmpty()) {
                Job job = heap.poll();
                time += job.l;
                answer += time - job.s;
                count++;
            }
            else {
                time = jobs[i][0];
            }
        }
        
        return answer / jobs.length;
    }
}
