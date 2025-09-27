import java.util.*;
class Solution {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        
        int[] answer = new int[s.length()];
        
        for(int i =0; i<s.length(); i++) {
            answer[i] = s.charAt(s.length() - i - 1) - '0'; // char -> int
        }
        
        return answer;
    }
}
