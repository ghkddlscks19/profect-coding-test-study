def solution(begin, target, words):
    answer = 1000
    flag = 0
    start = begin
    visited = [0] * len(words)
    
    def can_change(a, b):
        diff = 0
        for x, y in zip(a, b):
            if x != y:
                diff += 1
                if diff > 1:
                    return False
        return diff == 1

    def dfs(start, count, visited):
        nonlocal answer, flag
        if start == target:
            answer = min(answer,count)
            flag = 1
            return
        for i in range(len(words)):
            if not visited[i] and can_change(start, words[i]): 
                visited[i] = 1
                dfs(words[i], count + 1, visited)
                visited[i] = 0            
    dfs(start,0,visited)
    if not flag:
        return 0
    return answer
