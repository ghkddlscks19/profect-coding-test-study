class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = "";
        
        while(n > 0) {
            s += String.valueOf(n % 3);
            n /= 3;
        }
        
        answer = Integer.parseInt(s, 3);
        return answer;
    }
}
