import java.util.*;

class Solution {
    public String solution(String input_string) {
        Set<Character> set = new HashSet<>();
        
        for (int i = 0; i < input_string.length(); i++) {
            char c = input_string.charAt(i);
            
            int end = i;
            for (int j = i + 1; j < input_string.length(); j++) {
                if (input_string.charAt(j) == c) {
                    end = j;
                } else {
                    break;
                }
            }
            
            String str = "";
            if (end + 2 < input_string.length()) {
                str = input_string.substring(end + 2);
            }
            
            if (str.indexOf(c) != -1) {
                set.add(c);
            }
        }
        
        if (set.isEmpty())
            return "N";
        
        List<Character> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sortedList.size(); i++) {
            sb.append(sortedList.get(i));
        }
        
        String answer = sb.toString();
        
        return answer;
    }
}
