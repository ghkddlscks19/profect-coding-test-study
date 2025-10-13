import java.util.*;
class Solution {
    static HashSet<Integer> hs = new HashSet<>();
    static int answer = 0;
    static boolean[] visited;
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        dfs(numbers, "", 0);
        isPrime();
        return answer;
    }
    
    // 종이 조각 전부 만들기
    static void dfs(String numbers, String curr, int depth) {
        if(depth == numbers.length()) return;
        
        for(int i =0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                hs.add(Integer.parseInt(curr + numbers.charAt(i)));
                dfs(numbers, curr + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }
    
    // 소수 판별 후 개수 세기
    static void isPrime() {
        int max = 0;
        for(int x: hs) {
            max = Math.max(max, x);
        }
        
        boolean[] prime = new boolean[max + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        
        for(int i =2; i<=Math.sqrt(max); i++) {
            if(prime[i]) {
                for(int j =i*i; j<=max; j+=i) {
                    prime[j] = false;
                }              
            }
        }
        
        for(int x: hs) {
            if(prime[x] == true) answer++;
        }
    }
}
