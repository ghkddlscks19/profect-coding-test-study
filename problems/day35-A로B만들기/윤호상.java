import java.util.*;
class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        char[] arr1 = before.toCharArray();
        char[] arr2 = after.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(Arrays.equals(arr1, arr2)){
            answer = 1;
        }else
            answer = 0;
        
        return answer;
    }
}
