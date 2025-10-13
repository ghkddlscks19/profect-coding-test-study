import java.util.*;
class Solution {
    boolean[] check;
    Set<Integer> prime;
    
    public int solution(String numbers) {
        check = new boolean[numbers.length()];
        prime = new HashSet<>();
        dfs("", numbers);
        return prime.size();
    }
    
     public void dfs(String currentNum, String numbers) {
        if (!currentNum.isEmpty()) {
            int num = Integer.parseInt(currentNum);
            if (isPrime(num)) {
                prime.add(num);
            }
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(currentNum + numbers.charAt(i), numbers);
                check[i] = false; 
            }
        }
    }
    
    public boolean isPrime(int num) {
        if(num <= 1)
            return false;
        for (int i = 2; i <= num / 2; i++) { 
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
