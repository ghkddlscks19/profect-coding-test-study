import java.util.*;
class Solution {
    static Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        // info 전처리
        for (String s : info) {
            String[] parts = s.split(" ");
            String[] langs = {parts[0], "-"};
            String[] jobs = {parts[1], "-"};
            String[] exps = {parts[2], "-"};
            String[] foods = {parts[3], "-"};
            int score = Integer.parseInt(parts[4]);

            // 16가지 조합 생성
            for (String l : langs)
                for (String j : jobs)
                    for (String e : exps)
                        for (String f : foods)
                            map.computeIfAbsent(l + j + e + f, k -> new ArrayList<>()).add(score);
        }

        // 각 리스트 정렬
        for (List<Integer> list : map.values())
            Collections.sort(list);

        // 쿼리 처리
        List<Integer> answer = new ArrayList<>();
        for (String q : query) {
            q = q.replaceAll(" and ", "");
            String[] parts = q.split(" ");
            String key = parts[0];
            int minScore = Integer.parseInt(parts[1]);

            if (map.containsKey(key)) {
                List<Integer> scores = map.get(key);
                // minScore 이상인 첫 인덱스
                int idx = lowerBound(scores, minScore);
                //  나머지 사람 수
                answer.add(scores.size() - idx); 
            } else {
                answer.add(0);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
