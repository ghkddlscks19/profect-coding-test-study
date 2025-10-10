def solution(answers):
    answer = []
    problemCount = len(answers)
    one = [1,2,3,4,5]
    two = [2,1,2,3,2,4,2,5]
    three = [3,3,1,1,2,2,4,4,5,5]
    minimum = problemCount // 5 + 1
    one *= minimum
    two *= minimum
    three *= minimum
    
    oneResolve, twoResolve, threeResolve = 0, 0, 0
    for i in range(problemCount):
        if answers[i] == one[i]:
            oneResolve += 1
        if answers[i] == two[i]:
            twoResolve += 1
        if answers[i] == three[i]:
            threeResolve += 1
    
    solution = [oneResolve, twoResolve, threeResolve]
    maxNum = max(solution)
    for i in range(3):
        if solution[i] == maxNum:
            answer.append(i+1)
    
    return answer