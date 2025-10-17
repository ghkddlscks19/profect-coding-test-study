import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int total = citations.length;
        for (int i = 0; i < total; i++) {
            if(citations[i] >= total - i) {
                answer = total - i;
                break;
            }
        }
        
        return answer;
    }
}
