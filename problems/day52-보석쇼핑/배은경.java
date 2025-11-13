import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < gems.length; i++)
            set.add(gems[i]);
        int size = set.size();

        Map<String, Integer> map = new HashMap<>();
        int s = 0;
        int e = 0;
        int min = Integer.MAX_VALUE;

        while (e < gems.length) {
            map.put(gems[e], map.getOrDefault(gems[e], 0) + 1);
            e++;

            while (map.size() == size) {
                if (e - s < min) {
                    min = e - s;
                    answer[0] = s + 1;
                    answer[1] = e;
                }

                map.put(gems[s], map.get(gems[s]) - 1);
                if (map.get(gems[s]) == 0)
                    map.remove(gems[s]);
                s++;
            }
        }
        return answer;
    }
}
