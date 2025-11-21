from collections import deque

def solution(begin, target, words):
    answer = 0
    if target not in words:
        return answer
    
    n = len(words)
    queue = deque([[begin, 0]])
    isVisited = [0] * n
    
    def check(w1, w2):
        inconsist = 0
        for i in range(len(begin)):
            if w1[i] != w2[i]:
                inconsist+=1
            if inconsist >=2:
                return False
        return True
    
    while queue:
        word, step = queue.popleft()
        if word == target:
            return step
        
        for i in range(n):
            if isVisited[i] == 0 and check(word, words[i]):
                isVisited[i] = 1
                queue.append([words[i], step+1])
        
    return answer