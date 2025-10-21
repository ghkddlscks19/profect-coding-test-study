import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        
        for (String order : orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            
            for (int i = 0; i < course.length; i++) {
                boolean[] visited = new boolean[orderArray.length];
                
                combine(orderArray, visited, 0, orderArray.length, course[i], map);
            }
        }
        
        for (int i = 0; i < course.length; i++) {
            int maxCount = 0;
            List<String> maxKeys = new ArrayList<>();
            for (String key : map.keySet()) {
                if (key.length() == course[i]) {
                    int count = map.get(key);

                    if (count > maxCount) {
                        maxCount = count;
                        maxKeys.clear();
                        maxKeys.add(key);
                    } else if (count == maxCount) {
                        maxKeys.add(key);
                    }
                }
            }
            if (maxCount < 2)
                continue;
            
            for(String key : maxKeys) {
                answer.add(key);
            }
        }
        
        String[] result = answer.toArray(new String[0]);
        Arrays.sort(result);
        
        return result;
    }
    
    public void combine(char[] arr, boolean[] visited, int start, int n, int r, Map<String, Integer> map) {
        if (r == 0) {
            String str = "";
            
            for (int i = 0; i < n; i++) {
                if (visited[i])
                    str += arr[i];
            }
            
            if (map.containsKey(str)) {
                int value = map.get(str);
                map.put(str, value + 1);
            }
            else {
                map.put(str, 1);
            }
            
            return;
        }
        
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combine(arr, visited, i + 1, n, r - 1, map);
            visited[i] = false;
        }
    }
}
