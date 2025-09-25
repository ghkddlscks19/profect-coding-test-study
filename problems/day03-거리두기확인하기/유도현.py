def checkPartition(places,num,x1,y1,x2,y2):
    count = 0
    max_y = max(y1,y2)
    min_y = min(y1,y2)
    for i in range(x1,x2+1):
        for j in range(min_y, max_y+1):
            if places[num][i][j] == 'X':
                count += 1
    if x1 == x2 or y1 == y2:
        if count == 0:
            return 0
    else:
        if count != 2:
            return 0
    return 1

def check(places,data,num):
    for i in range(len(data)-1):
        for j in range(i+1,len(data)):
            if abs(data[i][0] - data[j][0]) + abs(data[i][1] - data[j][1]) == 1:
                return 0
            if abs(data[i][0] - data[j][0]) + abs(data[i][1] - data[j][1]) == 2:
                re = checkPartition(places,num,data[i][0],data[i][1],data[j][0],data[j][1])
                if not re:
                    return 0
    return 1

def solution(places):
    answer = []
    for k in range(len(places)):
        data = []
        for i in range(len(places[k])):
            for j in range(len(places[k][i])):
                if places[k][i][j] == 'P':
                    data.append([i,j])
        data = sorted(data, key = lambda x : (x[0], x[1]))
        answer.append(check(places,data,k))
    return answer