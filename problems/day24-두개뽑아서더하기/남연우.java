import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1;  j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        List<Integer> tmpSet = new ArrayList<>(set);
        Collections.sort(tmpSet);
        
        int[] answer = new int[set.size()];
        int i = 0;
        for (Integer num : tmpSet) {
            answer[i++] = num.intValue();
        }
        
        return answer;
    }
}
