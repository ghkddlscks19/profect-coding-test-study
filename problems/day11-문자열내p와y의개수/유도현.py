def solution(s):
    answer = True
    pCount = 0
    yCount = 0
    
    pCount += s.count("p")
    pCount += s.count("P")
    yCount += s.count("y")
    yCount += s.count("Y")

    if pCount == yCount:
        return True
    else:
        return False