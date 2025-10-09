import java.util.*;
class Solution {
    static List<String> dict = new ArrayList<>(); // 사전 리스트
    static String[] moeum = {"A","E","I","O","U"}; // 모음 배열
    
    public int solution(String word) {
        dfs("", 0);
        
        int answer = 0;
        
        for(int i =0; i<dict.size(); i++) {
            if(dict.get(i).equals(word)) {
                answer = i;
            }
        }
        
        
        return answer;
    }
    
    static void dfs(String curr, int depth) {
        dict.add(curr); // 사전에 먼저 넣기
        
        if(depth == 5) return;
        
        for(int i =0; i<5; i++) {
            dfs(curr + moeum[i], depth+1);
        }
    }
}
