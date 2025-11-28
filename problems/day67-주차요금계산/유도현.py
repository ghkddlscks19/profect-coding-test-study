import math

def solution(fees, records):
    answer = []
    time = dict()
    inout = dict()
    money = dict()
    for i in records:
        if i[6:10] not in time:
            time[i[6:10]] = 0
            inout[i[6:10]] =i[0:5] + "in"  
        else:
            if "IN" == i[11:13]:
                inout[i[6:10]] = i[0:5] + "in"
            else:
                time[i[6:10]] += int(i[0:2]) * 60 + int(i[3:5]) - (int(inout[i[6:10]][0:2]) * 60 + int(inout[i[6:10]][3:5]))
                print(int(i[0:2]) * 60 + int(i[3:5]) , (int(inout[i[6:10]][0:2]) * 60 + int(inout[i[6:10]][3:5])))
                inout[i[6:10]] = "out"
        
    end_time = 23 * 60 + 59
    
    for i in inout.keys():
        if "in" in inout[i]:
            time[i] += end_time - (int(inout[i][0:2])*60 + int(inout[i][3:5]))

    for i in time.items():
        if fees[0] >= i[1]:
            money[int(i[0])] = fees[1]
        else:
            money[int(i[0])] = fees[1] + math.ceil((i[1]-fees[0]) / fees[2]) * fees[3]
    print(time)
    print(money)
    for i in sorted(money.items(), key=lambda item:item[0]):
        answer.append(i[1])
    return answer