def solution(triangle):
    answer = 0
    dp = [triangle[0]]
    
    for i in range(1, len(triangle)):
        tmp = []
        for j in range(len(triangle[i])):
            curr = triangle[i][j]
            if j == 0:
                tmp.append(dp[i-1][0] + curr)
            elif j == (len(triangle[i])-1):
                tmp.append(dp[i-1][-1] + curr)
            else:
                tmp.append(max(dp[i-1][j-1], dp[i-1][j]) + curr)
        dp.append(tmp)
        
    answer = max(dp[-1])
    
    return answer