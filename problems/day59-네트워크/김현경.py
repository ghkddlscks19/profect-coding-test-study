def solution(n, computers):
    answer = 0
    isVisited = [0] * n 
            
    def dfs(i):
        isVisited[i] = 1
        
        for j in range(n):
            if computers[i][j] ==1 and isVisited[j] == 0:
                dfs(j)
                
    for i in range(n):
        if isVisited[i] == 0:
            dfs(i)
            answer+=1
            
    return answer