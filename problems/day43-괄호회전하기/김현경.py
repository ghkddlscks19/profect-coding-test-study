def count(s):
    b_map = {")":"(", "}":"{","]":"["}
    stack =[]
    for i in s:
        if i in "{([":
            stack.append(i)
        elif i in "}])":
            if not stack:
                return -1
            pair = stack.pop()
            if b_map[i] != pair:
                return -1
    if stack:
        return -1
    return 0

def solution(s):
    check = len(s)
    sum = 0

    while check > 0:
        r = count(s)
        if r ==0:
            sum+=1
        check -= 1
        front = s[0]
        back = s[1:]
        s = back + front
    
    
    return sum