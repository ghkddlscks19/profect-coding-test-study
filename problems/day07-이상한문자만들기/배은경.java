class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                answer += ' ';
                idx = -1;
            }
            else if (idx % 2 == 0) 
                answer += String.valueOf(Character.toUpperCase(s.charAt(i)));
            else 
                answer += String.valueOf(Character.toLowerCase(s.charAt(i)));
            idx++;
        }
        return answer;
    }
}
