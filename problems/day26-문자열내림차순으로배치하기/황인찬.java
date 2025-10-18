import java.util.*;
class Solution {
    public String solution(String s) {
        // 배열로 변환
        char[] arr = s.toCharArray();
        
        // 정렬
        Arrays.sort(arr);
        
        // StringBuilder에 정답 추가
        StringBuilder sb = new StringBuilder();
        
        for(int i =arr.length - 1; i>=0; i--) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
