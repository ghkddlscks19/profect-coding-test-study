import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        // 중복 되지 않게 정렬이 되어 있어야함. treeset이 딱이다
        TreeSet<Integer> ts = new TreeSet<>();
        
        for(int i =0; i<numbers.length; i++) {
            for(int j =i+1; j<numbers.length; j++) {
                ts.add(numbers[i] + numbers[j]);
            }
        }
        
        return ts.stream().mapToInt(Integer::intValue).toArray(); 
    }
}
