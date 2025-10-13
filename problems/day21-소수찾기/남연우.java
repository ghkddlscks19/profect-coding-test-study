import java.util.*;

class Solution {
    public boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    
    public void permute(String picked, String numbers, int length, Set<Integer> set) {
        if (picked.length() == length) {
            set.add(Integer.parseInt(picked));
            return;
        }
        else {
            for (int i = 0; i < numbers.length(); i++) {
                permute(
                    picked + numbers.charAt(i), 
                    numbers.substring(0, i) + numbers.substring(i + 1),
                    length, set
                );
            }
        }
    }
    
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet<>(); //중복을 없애기 위해서 set 사용
        
        for (int i = 1; i <= numbers.length(); i++)
            permute("", numbers, i, set);
        
        for (int n : set)
            if (isPrime(n))
                answer++;
        
        return answer;
    }
}
