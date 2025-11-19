class Solution {
    private int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    private void dfs(int[] numbers, int target, int depth, int sum){
        if(numbers.length == depth){
            if(sum == target){
                answer++;
            }
            return;
        }
        
        int plus = sum + numbers[depth];
        int minus = sum - numbers[depth];
        
        dfs(numbers, target, depth + 1, plus);
        dfs(numbers, target, depth + 1, minus);
    }
}
