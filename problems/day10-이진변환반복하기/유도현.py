def toBinary(s):
    temp = []
    while s != 0:
        temp.append(str(s % 2))
        s //= 2
    temp.reverse()
    ts = ''.join(temp)
    return ts

def solution(s):
    answer = []
    count, zeroCount = 0, 0
    ts = s
    while ts != "1" :
        temp = ""
        count += 1
        for i in range(len(ts)):
            if ts[i] == "1":
                temp += "1"
            else:
                zeroCount += 1
        if len(temp) == 0:
            break
        ts = toBinary(len(temp))
    answer.append(count)
    answer.append(zeroCount)
        
    return answer