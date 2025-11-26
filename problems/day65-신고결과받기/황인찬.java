import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고 당한사람, 신고 한사람(중복x)
        Map<String, Set<String>> reportMap = new HashMap<>();
       
        for(String id: id_list) {
            reportMap.put(id, new HashSet<>());
        }
        
        // 신고 맵에 값 넣기
        for(String s: report) {
            String[] input = s.split(" ");
            String reporter = input[0];
            String reported = input[1];
            
            reportMap.get(reported).add(reporter);
        }
        
        // k번 이상 신고 당한 사람 찾기
        Set<String> reportedSet = new HashSet<>();
        for(String key: reportMap.keySet()) {
            if(reportMap.get(key).size() >= k) {
                reportedSet.add(key);
            }
        }
        
        // 메일 받을 횟수 계산
        Map<String, Integer> mailCountMap = new HashMap<>();
        for(String id: id_list) {
            mailCountMap.put(id, 0);
        }
        
        for(String reported: reportedSet) {
            for(String reporter: reportMap.get(reported)) {
                mailCountMap.put(reporter, mailCountMap.get(reporter) + 1);
            }
        }
        
        // id_list 순서대로 담기
        int[] answer = new int[id_list.length];
        for(int i =0; i<id_list.length; i++) {
            answer[i] = mailCountMap.get(id_list[i]);
        }
       
        return answer;
    }
}
