import java.util.*;

class Solution {
    static Map<String, List<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();
        
        String[][] qr = new String[query.length][2];
        for (int i = 0; i < info.length; i++) {
            String[] per = info[i].split(" ");
            createKey(per, "", 0);
        }
    
        for(String key : map.keySet())
            Collections.sort(map.get(key));

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replace(" and", "");
            String[] arr = query[i].split(" ");
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 4; j++) {
                sb.append(arr[j]);
            }
            qr[i][0] = sb.toString();
            qr[i][1] = arr[4];
        }

        
        for (int i = 0; i < query.length; i++) {
            String key = qr[i][0];
            int score = Integer.parseInt(qr[i][1]);

            if (!map.containsKey(key)) {
                answer[i] = 0;
                continue;
            }

            List<Integer> list = map.get(key);
            int idx = binary(list, score);
            
            answer[i] = list.size() - idx;
        }
        return answer;
    }
    
    private void createKey(String[] per, String str, int depth) {
        if (depth == 4) {
            int score = Integer.parseInt(per[4]);
            map.computeIfAbsent(str, k -> new ArrayList<>()).add(score);
            return;
        }

        createKey(per, str + per[depth], depth + 1);
        createKey(per, str + "-", depth + 1);
    }

    private int binary(List<Integer> list, int score) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (score > list.get(mid))
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

}
