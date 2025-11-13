from collections import defaultdict

def solution(gems):
    total = len(set(gems))
    n = len(gems)

    answer = [1, n]   
    minL = n + 1 
    
    start = 0   
    cnt = defaultdict(int)

    for end in range(n):
    
        cnt [gems[end]] += 1
        while len( cnt ) == total:
            currL = end - start + 1
            if currL < minL:
                minL = currL
                answer = [start + 1, end + 1] 
            
            r = gems[start]
            cnt[r] -= 1

            if  cnt [r] == 0:
                del  cnt [r]
            
            start += 1

    return answer