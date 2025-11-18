def solution(numbers, hand):
    answer = ''
    dict = {
        1:(0,0), 2:(0,1), 3:(0,2),
        4:(1,0), 5:(1,1), 6:(1,2),
        7:(2,0), 8:(2,1), 9:(2,2),
        '*':(3,0), 0:(3,1), '#':(3,2),
    }
    curLPos = dict["*"]
    curRPos = dict["#"]
    
    for i in numbers:
        if i in [1,4,7]:
            answer+='L'
            curLPos= dict[i]
        elif i in [3,6,9]:
            answer+='R'
            curRPos = dict[i]
        else:
            current = dict[i]
            leftDist = abs(curLPos[0]-current[0])+abs(curLPos[1]-current[1])
            rightDist = abs(curRPos[0]-current[0])+abs(curRPos[1]-current[1])
            if leftDist > rightDist:
                answer+='R'
                curRPos = current
            elif leftDist < rightDist:
                answer+='L'
                curLPos = current
            else:
                if hand=="right":
                    answer+='R'
                    curRPos = current
                else:
                    answer+='L'
                    curLPos = current
    return answer