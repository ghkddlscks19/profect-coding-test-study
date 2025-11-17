from collections import deque

def solution(skill, skill_trees):
    answer = 0
    for st in skill_trees:
        que = deque(skill)
        flag = 0
        for j in range(len(st)):
            if st[j] in que:
                if st[j] == que[0]: # 있으면 뺴고
                    que.popleft()
                    continue
                flag = 1
                break
        if not flag:
            answer += 1
            
    return answer