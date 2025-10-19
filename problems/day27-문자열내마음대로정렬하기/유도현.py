from collections import defaultdict

def solution(strings, n):
    answer = []
    dic = defaultdict(list)
    for string in strings:
        dic[string[n]].append(string)
    
    for value in dic.values():
        value.sort()
    
    keys = list(dic.keys())
    keys.sort()
    for key in keys:
        for value in dic[key]:
            answer.append(value)
    
    return answer