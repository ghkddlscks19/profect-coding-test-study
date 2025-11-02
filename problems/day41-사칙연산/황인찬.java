class Solution {
    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;
        
        // dp[i][j][0]: 최댓값, dp[i][j][1]: 최솟값
        int[][][] dp = new int[n][n][2];
        
        // 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = Integer.MIN_VALUE;
                dp[i][j][1] = Integer.MAX_VALUE;
            }
        }
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(arr[i*2]);
            dp[i][i][0] = num;
            dp[i][i][1] = num;
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                
                for (int k = i; k < j; k++) {
                    String op = arr[k * 2 + 1];
                    
                    if (op.equals("+")) {
                        dp[i][j][0] = Math.max(dp[i][j][0], 
                                               dp[i][k][0] + dp[k + 1][j][0]);
                        dp[i][j][1] = Math.min(dp[i][j][1], 
                                               dp[i][k][1] + dp[k + 1][j][1]);
                    } else {
                        dp[i][j][0] = Math.max(dp[i][j][0], 
                                               dp[i][k][0] - dp[k + 1][j][1]);
                        dp[i][j][1] = Math.min(dp[i][j][1], 
                                               dp[i][k][1] - dp[k + 1][j][0]);
                    }
                }
            }
        }
        
        return dp[0][n - 1][0];
    }
}
