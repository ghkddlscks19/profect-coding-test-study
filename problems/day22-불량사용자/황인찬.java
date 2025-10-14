import java.util.*;
class Solution {
    static HashSet<String> hs = new HashSet<>();
    static boolean visited[];
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        dfs(user_id, banned_id, 0);
        
        int answer = hs.size();
        return answer;
    }
    
    static void dfs(String[] user_id, String[] banned_id, int depth) {
        if(depth == banned_id.length) {
            List<Integer> list = new ArrayList<>(); // 선택된 것 저장
            
            for(int i =0; i<visited.length; i++) {
                if(visited[i]) list.add(i);
            }
            
            Collections.sort(list); // 순서가 다른거도 중복이니까 정렬해서 set에 넣어 체크
            hs.add(list.toString());
            
            return;
        }
        
        for(int i =0; i<user_id.length; i++) {
            // 방문 안했고 user_id와 banned_id 비교해서 같을 때만 dfs 진행
            if(!visited[i] && isMatch(user_id[i], banned_id[depth])) {
                visited[i] = true;
                dfs(user_id, banned_id, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    static boolean isMatch(String userId, String bannedId) {
        if((bannedId.length() != userId.length())) {
           return false;
        }
        
         for(int i =0; i<userId.length(); i++) {
            if(bannedId.charAt(i) == '*') continue;
            if(userId.charAt(i) != bannedId.charAt(i)) return false;
        }
        
        return true;
    }
}
