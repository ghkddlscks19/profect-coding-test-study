def solution(s):
    answer = 0
    texts = []
    lenS = len(s)
    if len(s) == 1:
        return 1
    for i in range(1,len(s) // 2 + 1): 
        unit = ""
        before = s[:i]
        start = i
        count = 1
        while start < lenS: 
            if before == s[start:start+i]:
                count += 1
            else: 
                if count != 1:
                    unit = unit + str(count) + before
                    count = 1
                else:
                    unit = unit + before 
                before = s[start:start+i] 
            start += i

        if s[start-i-i:start-i] == s[start-i:]:
            unit = unit + str(count) + s[start-i:]
        else:
            unit += s[start-i:]
        texts.append(unit) 

    texts.sort(key = lambda x : (len(x)))
    answer = len(texts[0])
    return answer