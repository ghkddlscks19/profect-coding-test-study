class Solution {
    boolean solution(String s) {
        // 대,소문자를 구분하지 않으므로 소문자로 통일
        s = s.toLowerCase();
        int p = 0;
        int y = 0;
        
        for(int i =0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'p') {
                p++;
            } else if(c == 'y') {
                y++;
            }
        }
        
        boolean answer = true;
        if(p != y) answer = false;

        return answer;
    }
}
