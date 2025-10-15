import java.util.*;
class Solution {
    public long solution(String expression) {
        char[][] priorities = {
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '+', '*'},
            {'-', '*', '+'},
            {'*', '-', '+'},
            {'*', '+', '-'},
        };
        
        long answer = 0;
        for(char[] priority: priorities) {
            answer = Math.max(answer, Math.abs(calc(priority, expression)));
        }
        
        return answer;
    }
    
    static long calc(char[] priority, String expression) {
        // 숫자와 문자 분리해서 저장
        List<Long> numList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        
        String[] numArr = expression.split("[+\\-*]"); // 정규식을 이용한 숫자 추출
        for(String num: numArr) {
            numList.add(Long.parseLong(num));
        }
        
        // 문자 추출 후 저장
        for(char c: expression.replaceAll("[0-9]", "").toCharArray()) {
            opList.add(c);
        }
        
        // 연산자 우선순위에 맞게 꺼내서 연산
        for(char op: priority) {
            // 우선순위에 해당하는 연산자가 있을 때까지 반복
            while(opList.contains(op)) {
                int idx = opList.indexOf(op);
                long a = numList.get(idx);
                long b = numList.get(idx + 1);
                long result = operation(a, b, op); 
                
                // 연산 후 리스트에서 제거하고 현재 인덱스에 결과 값 추가
                numList.remove(idx);
                numList.remove(idx);
                numList.add(idx, result);
                opList.remove(idx);
            }
        }
        
        
        
        return numList.get(0);
    }
    
    static long operation(long a, long b, char c) {
        if(c == '+') {
            return a + b;
        } else if(c == '-') {
            return a - b;
        } else {
            return a * b;
        }
    }
}
