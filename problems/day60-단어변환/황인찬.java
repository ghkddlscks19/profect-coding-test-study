class Solution {
    int answer = 0;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length]; // 방문처리
        dfs(begin, target, words, 0);
        return answer;
    }
    
    void dfs(String curr, String target, String[] words, int cnt) {
        if(curr.equals(target)) {
            answer = cnt;
            return;
        }
        
        // 단어 순회하면서 한개의 알파벳만 바꿀 수 있음
        for(int i =0; i<words.length; i++) {
            if(visited[i]) continue;
            
            int diff = 0;
            
            for(int j =0; j<words[i].length(); j++) {
                if(curr.charAt(j) != words[i].charAt(j)) diff++;   
            }
            
            // 1개만 다르면 방문처리 -> 방문 -> 방문해제
            if(diff == 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
            
        }
    }
}
