import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> days = new LinkedList<>();
        int[] answer = new int[progresses.length];
        int index = 0;
        
        for (int i = 0; i < progresses.length; i++) {
            int num = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            days.offer(num);
        }
        
        int count = 1;
        int preNum = days.poll();
        
        while (!days.isEmpty()) {
            int num = days.poll();
            if (preNum >= num)
                count++;
            else {
                answer[index++] = count;
                count = 1;
                preNum = num;
            }
        }
        answer[index++] = count;
        
        return Arrays.copyOf(answer, index);
    }
}
