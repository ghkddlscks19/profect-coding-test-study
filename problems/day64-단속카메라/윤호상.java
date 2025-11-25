import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int camera = Integer.MIN_VALUE;
        
        Arrays.sort(routes, (a,b) -> a[1] - b[1]);
        
        for(int[] route : routes){
            int start = route[0];
            int end = route[1];
            
            if(camera < start){
                camera = end;
                answer++;
            }
        }
        
        return answer;
    }
}
