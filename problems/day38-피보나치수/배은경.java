class Solution {
    public int solution(int n) {
        long[] fb = new long[n + 1];
        fb[0] = 0;
        fb[1] = 1;
        
        for(int i = 2; i <= n; i++)
            fb[i] = (fb[i - 1] + fb[i - 2]) % 1234567; 
        
        int answer = (int)(fb[n] % 1234567);
        return answer;
    }
}
