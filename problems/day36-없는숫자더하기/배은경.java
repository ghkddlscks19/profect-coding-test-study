import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        
        int std = 0;
        int idx = 0;
        while(idx < numbers.length) {
            if(std != numbers[idx])
                answer += std;
            else
                idx++;
            std++;
        }
        
        for(int i = std; i < 10; i++)
            answer += i;
        
        return answer;
    }
}
