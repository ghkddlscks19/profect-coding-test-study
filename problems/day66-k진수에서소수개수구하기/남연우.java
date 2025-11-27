import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String result = Integer.toString(n, k);
        String[] arr = result.split("0");
        
        for (String a : arr) {
            if (a.isEmpty())
                continue;
            
            long num = Long.parseLong(a);
            if (isPrime(num))
                answer++;
        }
        
        return answer;
    }
    
    static boolean isPrime (long n) {
        if (n < 2)
            return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
