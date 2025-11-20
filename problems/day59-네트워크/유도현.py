def solution(n, computers):
    answer = 0
    visited = [0] * n
    
    def dfs(start):
        for i in range(n):
            if computers[start][i] == 1 and not visited[i]:
                visited[i] = 1
                dfs(i)
    
    for i in range(n):
        if not visited[i]:
            visited[i] = 1
            dfs(i)
            answer += 1
    
    return answer