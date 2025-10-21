from collections import defaultdict
from itertools import combinations

def solution(orders, course):
    answer = []
    numCount = defaultdict(int)
    for order in orders:
        order = sorted(order)
        for num in course:
            if len(order) < num:
                break
            for lis in combinations(order, num):
                combi = ''.join(lis)
                numCount[combi] += 1
    
    findMaxCount = defaultdict(list)
    for key, value in numCount.items():
        findMaxCount[len(key)].append(value)
    
    maxCount = defaultdict(int)
    for key, value in findMaxCount.items():
        maxCount[key] = max(value) 
    for cn in course:
        num = maxCount[cn]
        if num < 2:
            continue
        for key, value in numCount.items():
            if len(key) == cn and value == num:
                answer.append(key)
    answer.sort()
    
    return answer