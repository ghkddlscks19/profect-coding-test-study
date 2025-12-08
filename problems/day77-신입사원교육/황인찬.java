import java.util.*;
class Solution {
    public int solution(int[] ability, int number) {
        // 우선순위 큐에 넣기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a: ability) {
            pq.offer(a);
        }
        
        // 작은거 부터 빼서 더하고 다시 넣기
        for(int i =0; i<number; i++) {
            int n1 = pq.poll();
            int n2 = pq.poll();
            int sum = n1 + n2;
            
            pq.offer(sum);
            pq.offer(sum);
        }
        
        // 우선순위 큐에 있는 값 전부 더하기
        int answer = 0;
        for(int n: pq) {
            answer += n;
        }
        
        return answer;
    }
}
