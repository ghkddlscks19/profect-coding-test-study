import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        int n = id_list.length;
        int[] answer = new int[n];

        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) idx.put(id_list[i], i);

        Set<String> set = new HashSet<>(Arrays.asList(report));

        int[] reported = new int[n];

        Map<String, List<String>> who = new HashMap<>();
        for (String id : id_list) who.put(id, new ArrayList<>());

        for (String s : set) {
            String[] sp = s.split(" ");
            String from = sp[0];
            String to = sp[1];

            who.get(from).add(to);
            reported[idx.get(to)]++;
        }

        for (int i = 0; i < n; i++) {
            for (String to : who.get(id_list[i])) {
                if (reported[idx.get(to)] >= k)
                    answer[i]++;
            }
        }

        return answer;
    }
}
