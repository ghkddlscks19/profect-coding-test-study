from itertools import combinations

def solution(numbers):
    answer = []
    temp = set()
    for lis in combinations(numbers,2):
        temp.add(sum(lis))
    answer = list(temp)
    answer.sort()
    return answer