import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] graph = new int[n + 1][n + 1];
        
        //1 : 이김, -1 : 짐, 0 : 모름
        for (int[] r : results) {
            int winner = r[0];
            int loser = r[1];
            graph[winner][loser] = 1;
            graph[loser][winner] = -1;
        }
        
        //플로이드-워셜
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1; 
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (graph[i][j] != 0) count++;
            }
            
            if (count == n - 1)
                answer++;
        }
        
        return answer;
    }
}
