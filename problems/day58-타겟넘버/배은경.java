import java.util.*;

class Solution {
    static Set<String> set;
    static int answer = 0;
    public void dfs(int idx, int sum, int[] num, int target, String s) {
        if(idx == num.length) {
            if(sum == target && !set.contains(s)) {
                answer++;
                set.add(s);
            }
            return;
        }
        
        int n = num[idx];
        dfs(idx + 1, sum - num[idx], num, target, s.concat("-" + n));
        dfs(idx + 1, sum + num[idx], num, target, s.concat("+" + n));
    }
    public int solution(int[] numbers, int target) {
        set = new HashSet<>();
        dfs(0, 0, numbers, target, "");
        
        return answer;
    }
}
