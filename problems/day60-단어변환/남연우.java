import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < words.length; i++) {
            if (diff(begin, words[i]) == 1) {
                q.add(new int[]{i, 1});
                visited[i] = true;
            }
        }
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int idx = cur[0];
            int step = cur[1];

            if (words[idx].equals(target))
                return step;

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && diff(words[idx], words[i]) == 1) {
                    visited[i] = true;
                    q.add(new int[]{i, step + 1});
                }
            }
        }
        return 0;
    }
    
    static int diff(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i))
                cnt++;
        return cnt;
    }
}
