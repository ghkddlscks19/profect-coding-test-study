import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> map = new HashMap<>();
        TreeMap<String, Integer> time = new TreeMap<>();
        String[][] rc = new String[records.length][3];
        for(int i = 0; i < rc.length; i++)
            rc[i] = records[i].split(" ");
        
        for(int i = 0; i < rc.length; i++) {
            if(rc[i][2].equals("IN")) {
                map.put(rc[i][1], rc[i][0]);
            } else {
                String s = map.get(rc[i][1]);
                String[] s1 = s.split(":");
                String[] s2 = rc[i][0].split(":");
                
                int t1 = Integer.parseInt(s1[0]) * 60 + Integer.parseInt(s1[1]);
                int t2 = Integer.parseInt(s2[0]) * 60 + Integer.parseInt(s2[1]);
                time.put(rc[i][1], time.getOrDefault(rc[i][1], 0) + t2 - t1);
                map.remove(rc[i][1]);
            }
        }
        
        for(String key : map.keySet()) {
            String s = map.get(key);
            String[] s1 = s.split(":");
                
            int t1 = Integer.parseInt(s1[0]) * 60 + Integer.parseInt(s1[1]);
            int t2 = 23 * 60 + 59;
            time.put(key, time.getOrDefault(key, 0) + t2 - t1);
        }
        
        int[] answer = new int[time.size()];
        int idx = 0;
        for(String key : time.keySet()) {
            int t = time.get(key);
            int fee = 0;
            if(t > fees[0]) {
                fee += fees[1];
                t -= fees[0];
                if(t % fees[2] != 0)
                    fee += fees[3] * (t / fees[2] + 1);
                else
                    fee += fees[3] * (t / fees[2]);
            } else {
                fee = fees[1];
            }
            answer[idx++] = fee;
        }
        return answer;
    }
}
