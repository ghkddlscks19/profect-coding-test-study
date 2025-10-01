import java.util.*;
class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        // 어차피 순서대로 하면 반전된 결과
        while(n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        
        int answer = 0;
        int square = 0;
        for(int i =sb.length()-1; i>=0; i--) {
            int mul = (int) Math.pow(3, square);
            answer += (sb.charAt(i) - '0') * mul;
            square++;
        }
        return answer;
    }
}
