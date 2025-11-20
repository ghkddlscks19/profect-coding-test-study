class Solution {
    int answer = 0;
    boolean visited[];
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        // 모든 컴퓨터를 순회하며 네트워크 찾기
        for(int i =0; i<n; i++) {
            if(!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
    
    void dfs(int now, int[][] computers) {
        visited[now] = true;
        for(int i =0; i<computers.length; i++) {
            if(!visited[i] && computers[now][i] == 1) {
                // 방문하지 않았고 연결되어 있다면 방문
                dfs(i, computers);
            }
        }
    }
}
