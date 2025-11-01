def solution(m, n, puddles):
    MOD = 1000000007
    dp = [[0] * m for _ in range(n)]

    for x, y in puddles:
        if 0 <= y-1 < n and 0 <= x-1 < m:  
            dp[y-1][x-1] = -1

    if dp[0][0] == 0:
        dp[0][0] = 1 

 
    for i in range(n):  
        for j in range(m):  

            if dp[i][j] == -1:
                dp[i][j] = 0
                continue
            
            if i > 0:  
                dp[i][j] += dp[i-1][j]
            
            if j > 0:  
                dp[i][j] += dp[i][j-1]
            
            if i != 0 or j != 0:
                dp[i][j] %= MOD

    return dp[n-1][m-1]