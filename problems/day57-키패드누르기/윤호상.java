import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        Map<Integer, int[]> map = new HashMap<>();
        map.put(1, new int[]{0,0});
        map.put(2, new int[]{0,1});
        map.put(3, new int[]{0,2});
        map.put(4, new int[]{1,0});
        map.put(5, new int[]{1,1});
        map.put(6, new int[]{1,2});
        map.put(7, new int[]{2,0});
        map.put(8, new int[]{2,1});
        map.put(9, new int[]{2,2});
        map.put(0, new int[]{3,1});

        int[] leftPos = new int[]{3,0};  
        int[] rightPos = new int[]{3,2}; 

        StringBuilder sb = new StringBuilder();

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                leftPos = map.get(num);
            } 
            else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                rightPos = map.get(num);
            } 
            else { 
                int[] target = map.get(num);

                int leftDist = Math.abs(leftPos[0] - target[0]) + Math.abs(leftPos[1] - target[1]);
                int rightDist = Math.abs(rightPos[0] - target[0]) + Math.abs(rightPos[1] - target[1]);

                if (leftDist < rightDist) {
                    sb.append("L");
                    leftPos = target;
                } else if (leftDist > rightDist) {
                    sb.append("R");
                    rightPos = target;
                } else { 
                    if (hand.equals("right")) {
                        sb.append("R");
                        rightPos = target;
                    } else {
                        sb.append("L");
                        leftPos = target;
                    }
                }
            }
        }

        answer = sb.toString(); 
        return answer;
    }
}
