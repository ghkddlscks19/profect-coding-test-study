import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int idx = 0;
        int[] answer = new int[commands.length];
        for(int[] comm: commands) {
            int i = comm[0] - 1; 
            int j = comm[1];
            int k = comm[2] - 1; 
            
            int[] copy = Arrays.copyOfRange(array, i, j); // 배열 범위만큼 복사
            Arrays.sort(copy); // 복사한 배열 정렬
            
            answer[idx++] = copy[k];
        }
        return answer;
    }
}
