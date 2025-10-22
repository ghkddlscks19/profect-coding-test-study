from collections import defaultdict
from itertools import combinations
from bisect import bisect_left

def solution(information, querys):
    answer = []
    dic = defaultdict(list)
    for infos in information:
        info = infos.split()
        text = info[:-1]
        score = int(info[-1])
        for i in range(1,5):
            for lis in combinations(text,i):
                dic[''.join(lis)].append(score)
        dic[""].append(score)
    
    for value in dic.values():
        value.sort()
    
    for orders in querys:
        order = orders.replace("and ", "")
        order = order.replace("-", "")
        order = order.split()
        if len(order) == 1:
            target = dic[""]
            idx = bisect_left(target,int(order[0]))
            answer.append(len(target) - idx)
            continue
        key = ''.join(order[:-1])
        targetScore = int(order[-1])
        count = 0
        if key in dic:
            target = dic[key]
            idx = bisect_left(target, targetScore)
            count = len(target) - idx
        answer.append(count)
        
    return answer