import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (String oper : operations) {
            if (oper.charAt(0) == 'I') {
                int num = Integer.parseInt(oper.substring(2));
                maxQ.offer(num);
                minQ.offer(num);
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            else if (oper.charAt(0) == 'D') {
                if (oper.charAt(2) == '1') {
                    boolean deleted = false;
                    while(!deleted && !maxQ.isEmpty()) {
                        int num = maxQ.poll();
                        if (map.containsKey(num)) {
                            if (map.get(num) > 0) {
                                map.put(num, map.get(num) - 1);
                                deleted = true;
                            }
                        }
                    }
                }
                else {
                    boolean deleted = false;
                    while(!deleted && !minQ.isEmpty()) {
                        int num = minQ.poll();
                        if (map.containsKey(num)) {
                            if (map.get(num) > 0) {
                                map.put(num, map.get(num) - 1);
                                deleted = true;
                            }
                        }
                    }
                }
            }
        }
        
        boolean found = false;
        int max = 0;
        while(!found && !maxQ.isEmpty()) {
            int num = maxQ.poll();
            if (map.containsKey(num)) {
                if (map.get(num) > 0) {
                    max = num;
                    found = true;
                }
            }
        }
        
        found = false;
        int min = 0;
        while(!found && !minQ.isEmpty()) {
            int num = minQ.poll();
            if (map.containsKey(num)) {
                if (map.get(num) > 0) {
                    min = num;
                    found = true;
                }
            }
        }
        
        answer[0] = max;
        answer[1] = min;
        
        return answer;
    }
}
