class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int l = 1; l <= s.length() / 2; l++){
            int rslt = check(s, l);
            if(rslt < answer)
                answer = rslt;
        }
        return answer;
    }
    
    public int check(String s, int n) {
        int len = 0;
        int cnt = 1;
        int i;
        
        for(i = 0; i + n <= s.length(); i += n) {
            if (i + 2 * n <= s.length() && s.substring(i, i + n).equals(s.substring(i + n, i + 2 * n))) 
                cnt++;
            else {
                if (cnt != 1)
                    len += n + String.valueOf(cnt).length();
                else
                    len += n;
                cnt = 1;
            }
        }
      
        if (cnt != 1)
            len += n + String.valueOf(cnt).length();
        if (i < s.length()) 
            len += s.length() - i;
        
        return len;
    }
}
