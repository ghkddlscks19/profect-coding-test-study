class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ')
                answer += c;
            else if(c + n > 'z')
                answer += Character.toString('a' + (c + n - 1) - 'z');
            else if (c < 'a' && c + n > 'Z')
                answer += Character.toString('A' + (c + n - 1) - 'Z');
            else
                answer += Character.toString(c + n);
        }
        return answer;
    }
}
