class Solution {
    public String solution(String new_id) {
        String answer = new_id;
        // 1단계
        answer = answer.toLowerCase();
        
        // 2단계
        StringBuilder sb = new StringBuilder();
        for(char c: answer.toCharArray()) {
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || 
               c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        answer = sb.toString();
        
        // 3단계
        while(answer.contains("..")) {
            answer = answer.replace("..", ".");
        }
        
        // 4단계
        if(answer.startsWith(".")) answer = answer.substring(1);
        if(answer.endsWith(".")) answer = answer.substring(0, answer.length() - 1);
        
        // 5단계
        if(answer.isEmpty()) answer = "a";
        
        // 6단계
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if(answer.endsWith(".")) answer = answer.substring(0, 14);
        }
        
        // 7단계
        while(answer.length() <= 2) {
            answer += answer.charAt(answer.length() - 1);
        }
        
        return answer;
    }
}
