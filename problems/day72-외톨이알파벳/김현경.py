def solution(input_string):
    answer = ''
    arr=[]
    every=[]
    for i in input_string:
        arr.append(i)
    #print(arr)
    
    for i in arr:
        if i in every:
            continue
        every.append(i)
    #print(every)
    
    if len(arr) == len(every):
        return 'N'
    
    def isContinuous(index):
        # print("index:", index)
        for i in range(1, len(index)):
            if index[i] != index[i-1]+1:
                return False
        return True
        
    for i in every:
        count = 0
        index = []
        for ind, val in enumerate(arr):
            if i == val:
                index.append(ind)
                count+=1
        print(index)
        if count >=2 and not isContinuous(index):
            answer=answer+i
            
    answer = sorted(answer)
    answer = "".join(answer)
    if not answer:
        return "N"
    # print("answer:",answer)
    return answer