class Solution {
    static int num;
    static boolean[] vst;
    public void dfs(int idx, int[][] com) {
        vst[idx] = true;
        for(int i = 0; i < num; i++)
            if(i != idx && vst[i] == false && com[idx][i] == 1)
                dfs(i, com);
        
        return;
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        num = n;
        vst = new boolean[n];
        
        for(int i = 0; i < n; i++)
            if(vst[i] == false) {
                dfs(i, computers);
                answer++;
            }
        
        return answer;
    }
}
