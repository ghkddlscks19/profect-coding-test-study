import java.util.*;
class Solution {
    public int solution(int n, int k) {
        // 진수 변환
        StringBuilder sb = new StringBuilder();
        
        if(k == 10) {
            sb.append(n);
        } else {
            while(n > 0) {
                sb.append(n % k);
                n /= k;
            }
            sb.reverse();
        }
        
        // 소수 개수
        int answer = 0;
        
        // 0을 기준으로 나눈 다음 소수가 있는지 판별
        String[] nums = sb.toString().split("0");
        
        
        for(String s: nums) {
            if(s.isEmpty()) continue;
            
            // 진법 변환 후 수가 커지는 걸 보니 Integer 부족할 수도 있음
            long num = Long.parseLong(s);
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    // 소수 구하는 메소드
    boolean isPrime(long num) {
        if(num == 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        
        for(long l =3; l*l<=num; l+=2) {
            if(num % l == 0) return false;
        }
        
        return true;
    }
}
