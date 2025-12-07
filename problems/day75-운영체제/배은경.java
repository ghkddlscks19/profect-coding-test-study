import java.util.*;

class Solution {
    public long[] solution(int[][] program) {
        long[] answer = new long[11];
        Arrays.sort(program, (a, b) -> {
            if(a[1] == b[1]) 
                return a[2] - b[2];       
            return a[1] - b[1];
        });
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        que.offer(program[0]);
        long time = program[0][1];
        int idx = 1;
        while(!que.isEmpty()) {
            int[] q = que.poll();
            answer[q[0]] += time - q[1];
            time += q[2];
            
            while(idx < program.length && program[idx][1] <= time)
                que.offer(program[idx++]);
            if(que.isEmpty() && idx < program.length) {
                time = program[idx][1];
                que.offer(program[idx++]);
            }
        }
        
        answer[0] = time;
        return answer;
    }
}
