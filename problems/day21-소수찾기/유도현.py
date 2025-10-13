from itertools import permutations

def solution(numbers):
    answer = 0
    result = set()
    data = list()
    for i in range(len(numbers)):
        data.append(numbers[i])
    for i in range(1,len(numbers)+1):
        for number in permutations(data,i):
            result.add(int(''.join(list(number))))
    for n in result:
        print(n)
        flag = 0
        if n < 2:
            continue
        for i in range(2,int(n**0.5)+1):
            if n % i == 0:
                flag = 1
                break
        if flag == 0:
            answer += 1
    return answer