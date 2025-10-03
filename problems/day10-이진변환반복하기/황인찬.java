class Solution {
    public int[] solution(String s) {
        int zero = 0; // 제거된 0의 개수
        int change = 0; // 이진 변환 횟수
         
        while(!s.equals("1")) {
            for(int i =0; i<s.length(); i++) {
                char c = s.charAt(i);
                if(c == '0') zero++;
            }
            s = s.replace("0", ""); // 0 제거
            s = Integer.toBinaryString(s.length()); // 길이를 2진법으로 변환
            change++;            
        }
        int[] answer = {change, zero};
        return answer;
    }
}
