class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
    
    void dfs(String begin, String target, String[] words, int node){
        
        if(begin.equals(target)){
            if(answer == 0 || node < answer){
                answer = node;
                return;
            }
        }
        
        for(int i = 0; i< words.length; i++){
            if (visited[i]) continue;
            
            int k = 0;    
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }
            
            if(k == begin.length() - 1){
                visited[i] = true;
                dfs(words[i], target, words, node + 1);
                visited[i] = false;
            }
        }
    }
}
