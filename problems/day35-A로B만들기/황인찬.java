import java.util.*;
class Solution {
    public int solution(String before, String after) {
        char[] beforeArr = before.toCharArray();
        char[] afterArr = after.toCharArray();
        
        Arrays.sort(beforeArr);
        Arrays.sort(afterArr);
        
        int answer = 1;
        
        for(int i =0; i<beforeArr.length; i++) {
            if(beforeArr[i] != afterArr[i]) {
                answer = 0; 
                break;
            }
        }
        
        
        return answer;
    }
}
