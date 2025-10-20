import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strings = new String[numbers.length];
        
        int i = 0;
        for (int num : numbers) {
            String string = Integer.toString(num);
            strings[i++] = string;
        }
            
        Arrays.sort(strings, (a, b) -> (b + a).compareTo(a + b));
        
        if (strings[0].equals("0"))
            return "0";
        
        for (String string : strings)
            answer += string;
        
        return answer;
    }
}
