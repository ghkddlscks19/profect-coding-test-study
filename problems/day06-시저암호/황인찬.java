public class Solution {
    public static String solution(String s, int n) {
        String answer = "";
        
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            // 소문자
            if(ch >= 'a' && ch <= 'z') {
                if(ch + n > 'z') { // z를 넘어간 경우
                    answer += (char) (ch + n - 26);
                } else {
                    answer += (char) (ch + n);
                }
            } else if(ch >= 'A' && ch <= 'Z') { // 대문자
                if(ch + n > 'Z') { // Z를 넘어간 경우
                    answer += (char) (ch + n - 26);
                } else {
                    answer += (char) (ch + n);
                }
            } else { // 공백
                answer += ch;
            }
        }
        return answer;
    }
}
