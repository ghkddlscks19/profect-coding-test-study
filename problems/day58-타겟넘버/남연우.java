class Solution {
    static int answer;
    static boolean[] visited;
    public int solution(int[] numbers, int target) {
        answer = 0;
        visited = new boolean[numbers.length];
        dfs(0, target, 0 + numbers[0], numbers);
        dfs(0, target, 0 - numbers[0], numbers);
        
        return answer;
    }
    static void dfs(int idx, int target, int sum, int[] numbers) {
        if (idx == numbers.length - 1) {
            if (sum == target)
                answer++;
            return;
        }
        
        visited[idx] = true;
        dfs(idx + 1, target, sum + numbers[idx + 1], numbers);
        dfs(idx + 1, target, sum - numbers[idx + 1], numbers);
        visited[idx] = false;
    }
}
