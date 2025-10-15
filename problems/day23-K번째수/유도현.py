def solution(array, commands):
    answer = []
    for i in range(len(commands)):
        s,e,k = commands[i][0], commands[i][1], commands[i][2]
        temp = array[s-1:e]
        temp.sort()
        answer.append(temp[k-1])
    return answer