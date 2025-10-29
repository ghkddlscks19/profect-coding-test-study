import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int len = completion.length;
        
        for(int i = 0; i < len; i++) 
            if(!participant[i].equals(completion[i]))
                return participant[i];
        return participant[len];
    }
}
