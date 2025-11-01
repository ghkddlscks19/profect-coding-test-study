class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];

        for (int[] p : puddles) {
            int x = p[0];
            int y = p[1];
            dp[y][x] = -1;
        }
      
        dp[1][1] = 1;
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                if (dp[r][c] == -1) {
                    dp[r][c] = 0;
                    continue;
                }
                if (r == 1 && c == 1)
                    continue;
                
                int up = 0;
                if (r > 1 && dp[r - 1][c] != -1)
                    up = dp[r - 1][c];
                
                int left = 0;
                if (c > 1 && dp[r][c - 1] != -1)
                    left = dp[r][c - 1];
                dp[r][c] = (up + left) % 1000000007; 
            }
        }

        return dp[n][m];
    }
}
