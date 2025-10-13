import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        
        char[] digits = numbers.toCharArray();
        Arrays.sort(digits);
        boolean[] used = new boolean[digits.length];
        Set<Integer> primes = new HashSet<>();
    
        for(int len = 1; len<=digits.length; len++){
            dfs(digits, used, len, new StringBuilder(), primes);
        }
        
        answer = primes.size();
        return answer;
    }
    
    private static void dfs(char[] digits, boolean[] used, int len, StringBuilder cur, Set<Integer> primes){
        if(cur.length()==len){
            int val = Integer.parseInt(cur.toString());
            if(isPrime(val)) primes.add(val);
            return;
        }   
        
        for(int i=0; i<digits.length; i++){
            if(used[i]) continue; // 같은 깊이에서는 중복 스킵
            if(i>0 && digits[i] == digits[i-1] && !used[i-1]) continue;
                
            used[i] = true;
            cur.append(digits[i]);
            dfs(digits, used, len, cur, primes);
            cur.deleteCharAt(cur.length() - 1);
            used[i] = false;
        }
    }
    
    private static boolean isPrime(int n){
            if(n<2) return false;
            if(n%2==0) return n==2;
            int r = (int) Math.sqrt(n);
            for(int i =3; i<=r; i+=2){
                if(n%i==0) return false;
            }
            return true;
        }
}
