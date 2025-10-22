import java.util.*;
class Solution {
    // 앞에 영어는 그대로 넣고 점수는 리스트 형태로 넣어서 보관
    static HashMap<String, List<Integer>> hm = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        // info 정제
        for(String in: info) {
            String[] arr = in.split(" ");            
            // -가 들어가는 경우의 수까지 하면 2^4의 개수가 필요
            String[] words = {arr[0], arr[1], arr[2], arr[3]};
            int score = Integer.parseInt(arr[4]);
            dfs(words, "", 0, score);
        }
        
        // 점수 정렬
        for(List<Integer> scoreList: hm.values()) {
            Collections.sort(scoreList);
        }
        
        int[] answer = new int[query.length];
        int idx = 0;
        
        // 쿼리 정제 후 해시맵에서 찾기
        for(String qu: query) {
            String[] arr = qu.replace(" and ", " ").split(" ");    
            String lang = arr[0];
            String role = arr[1];
            String exp = arr[2];
            String food = arr[3];
            String sentence = lang + role + exp + food;
            int score = Integer.parseInt(arr[4]);
            
            if(hm.containsKey(sentence)) {
                List<Integer> scoreList = hm.get(sentence);
                
                // 이분 탐색
                int left = 0;
                int right = scoreList.size() - 1;
        
                while(left <= right) {
                    int mid = (left + right) / 2;

                    if(scoreList.get(mid) >= score) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }   

                int count = scoreList.size() - left;
                answer[idx++] = count;     
                           
            } else {
                answer[idx++] = 0;
            }
        }
        
        
        return answer;
    }
    
    static void dfs(String[] words, String curr, int depth, int score) {
        if(depth == 4) {
            if(hm.get(curr) == null) {
                hm.put(curr, new ArrayList<>());
            }
            
            hm.get(curr).add(score);
            
            return;
        }
        
        // 단어 선택
        dfs(words, curr + words[depth], depth + 1, score);
        
        // 단어 선택 X
        dfs(words, curr + "-", depth + 1, score);     
    }
    
}
