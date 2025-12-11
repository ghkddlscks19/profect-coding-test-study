def solution(ability):
    answer = 0

    def dfs(count, total, pv, visited):
        nonlocal answer
        if count == len(visited): 
            answer = max(answer, total)
            return
        
        q = count
        for p in range(len(ability)): 
            if pv[p]:
                continue
            pv[p] = 1
            total += ability[p][q]
            dfs(count+1, total, pv, visited)
            total -= ability[p][q]
            pv[p] = 0 
        
    pv = [0 for _ in range(len(ability))] 
    visited = [0 for _ in range(len(ability[0]))]
    dfs(0, 0, pv, visited)
    return answer
