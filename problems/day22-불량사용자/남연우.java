import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {        
        List<List<Integer>> candidates = new ArrayList<>();
        
        for (int i = 0; i < banned_id.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < user_id.length; j++) {
                if (compare(user_id[j], banned_id[i])) {
                    list.add(j);
                }
            }
            candidates.add(list);
        }
        
        boolean[] used = new boolean[user_id.length];
        Set<String> result = new HashSet<>();
        dfs(0, candidates, used, user_id, result);
        
        return result.size();
    }
    
    public void dfs(int depth, List<List<Integer>> candidates, boolean[] used, String[] user_id, Set<String> result) {
        if (depth == candidates.size()) {
            List<String> chosen = new ArrayList<>();
            
            for (int i = 0; i < used.length; i++)
                if (used[i])
                    chosen.add(user_id[i]);
            
            Collections.sort(chosen);
            result.add(String.join(",", chosen));
            return;
        }
        
        for (int i = 0; i < candidates.get(depth).size(); i++) {
            int uIdx = candidates.get(depth).get(i);
            
            if (used[uIdx]) continue;
            
            used[uIdx] = true;
            dfs(depth + 1, candidates, used, user_id, result);
            used[uIdx] = false;
        }
    }
    
    public boolean compare(String u_id, String b_id) {
        if (u_id.length() != b_id.length())
            return false;
        
        for (int i = 0; i < u_id.length(); i++) {
            if (u_id.charAt(i) == '*' || b_id.charAt(i) == '*')
                continue;
            
            if (u_id.charAt(i) != b_id.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}
