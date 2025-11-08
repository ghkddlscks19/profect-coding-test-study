def solution(n, results):
    graph = [[False] * (n + 1) for _ in range(n + 1)]

    for winner, loser in results:
        graph[winner][loser] = True

    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if graph[i][k] and graph[k][j]:
                    graph[i][j] = True

    answer = 0
    for i in range(1, n + 1): 
        known_count = 0  
        for j in range(1, n + 1):  
            if i == j:
                continue
            if graph[i][j] or graph[j][i]:
                known_count += 1
        
        if known_count == n - 1:
            answer += 1
            
    return answer