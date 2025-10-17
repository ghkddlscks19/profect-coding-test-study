def solution(citations):
    answer = 0
    maxNum = max(citations)
    
    for i in range(maxNum, -1, -1): # 큰 값부터 내려가고 
        count = 0
        for citation in citations:
            if citation >= i:
                count += 1
        if count >= i:
            return i