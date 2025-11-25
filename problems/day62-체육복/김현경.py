def solution(n, lost, reserve):
    answer = 0
    real_lost = sorted(list(set(lost) - set(reserve)))
    real_reserve = sorted(list(set(reserve)-set(lost)))
    
    for i in real_reserve:
        if i-1 in real_lost:
            real_lost.remove(i-1)
            
        elif i+1 in real_lost:
            real_lost.remove(i+1)
    
    answer = n -len(real_lost)
    return answer