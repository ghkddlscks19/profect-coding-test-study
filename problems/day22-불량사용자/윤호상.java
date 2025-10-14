import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        
        List<List<Integer>> candidates = new ArrayList<>();
        
        for(String b : banned_id){
            List<Integer> list= new ArrayList<>();
            for(int i=0; i<user_id.length; i++){
                if(match(user_id[i], b))
                    list.add(i);
            }
            candidates.add(list);
        }
        
        boolean[] visited = new boolean[user_id.length];
        Set<Set<Integer>> seen = new HashSet<>();
        
        dfs(0, visited, candidates, seen);
        return seen.size();
    }
    
    private boolean match(String user, String ban){
        if(user.length() != ban.length()) 
            return false;
        for(int i=0; i<user.length(); i++){
            char bc = ban.charAt(i);
            if(bc == '*')
                continue;
            if(bc != user.charAt(i))
                return false;
        }
        return true;
    }
    
    private void dfs(int idx, boolean[] visited, List<List<Integer>> candidates, Set<Set<Integer>> seen){
        if(idx == candidates.size()){
            Set<Integer> combo = new HashSet<>();
            for(int i=0; i< visited.length; i++){
                if(visited[i])
                    combo.add(i);
            }
            seen.add(combo);
            return;
        }
        
        for(int u : candidates.get(idx)){
            if(visited[u])
                continue;
            visited[u] = true;
            dfs(idx + 1, visited, candidates, seen);
            visited[u] = false;
        }
    }
}
