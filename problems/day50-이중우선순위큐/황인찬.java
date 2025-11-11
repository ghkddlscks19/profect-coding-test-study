import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        
        // 연산들 순회
        for(String op: operations) {
            String[] input = op.split(" ");
            String alpha = input[0];
            int num = Integer.parseInt(input[1]);
            
            
            if(alpha.equals("I")) {
                // 삽입 연산
                tm.put(num, tm.getOrDefault(num, 0) + 1);
            }
            else {
                if(!tm.isEmpty()) {
                    int target = 0;
                    if(num == 1) {
                        // 최댓값
                        target = tm.lastKey();
                    } else {
                        // 최솟값
                        target = tm.firstKey();
                    }
                    
                    if(tm.get(target) == 1) {
                        // 남은 숫자가 하나면 제거
                        tm.remove(target);
                    } else {
                        // 남은 숫자가 여러개면 한개만 제거
                        tm.put(num, tm.get(target) - 1);
                    }
                }                             
            }
        }
        
        if(tm.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{tm.lastKey(), tm.firstKey()};
        }
    }
}
