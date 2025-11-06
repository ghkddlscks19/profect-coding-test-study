import math
def solution(progresses, speeds):
    answer = []
    pIdx = 0
    day = 0
    while pIdx < len(progresses):
        count = 1
        day = (100 - progresses[pIdx]) / speeds[pIdx]
        day = math.ceil(day)
        pIdx += 1
        if pIdx == len(progresses):
            answer.append(count)
            return answer
        while pIdx < len(progresses):
            if progresses[pIdx] + speeds[pIdx] * day >= 100:
                count += 1
                pIdx += 1
                continue
            break
        answer.append(count)
    return answer