class Solution {
    static boolean isPrime(Long num) {
        if(num == 0 || num == 1)
            return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++)
            if(num % i == 0)
                return false;
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            sb.append(n % k);
            n /= k;
        }
        
        String s = sb.reverse().toString();
        String[] arr = s.split("0");
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals(""))
                continue;
            if(isPrime(Long.parseLong(arr[i])))
                answer++;
        }
        return answer;
    }
}
