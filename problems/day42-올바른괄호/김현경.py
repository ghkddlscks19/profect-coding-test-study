def solution(s):
    cnt = 0
    
    for i in s:
        if i == '(':
            cnt += 1
        else:  
            if cnt == 0:
                return False 
            cnt -= 1
            
    if cnt != 0:
        return False
    else:
        return True