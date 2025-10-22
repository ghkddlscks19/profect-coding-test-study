import java.util.*;

class Solution {
    static Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (String str : info) {
            String[] arr = str.split(" ");
            String[] conditions = Arrays.copyOfRange(arr, 0, 4);
            int score = Integer.parseInt(arr[4]);
            dfs(conditions, "", 0, score);
        }

        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String q = query[i].replace(" and ", " ");
            String[] arr = q.split(" ");
            String key = String.join("", Arrays.copyOfRange(arr, 0, 4));
            
            int score = Integer.parseInt(arr[4]);

            if (map.containsKey(key)) {
                List<Integer> list = map.get(key);
                int idx = lowerBound(list, score);
                answer[i] = list.size() - idx;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    public void dfs(String[] arr, String key, int depth, int score) {
        if (depth == 4) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(score);
            return;
        }

        dfs(arr, key + arr[depth], depth + 1, score);
        dfs(arr, key + "-", depth + 1, score);
    }

    public int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target)
                left = mid + 1;
            else
                right = mid;
        }
        
        return left;
    }
}
