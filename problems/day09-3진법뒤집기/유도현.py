def solution(n):
    answer = 0
    temp = []
    num = n
    while num > 0:
        temp.append(num % 3)
        num //= 3
    temp.reverse()
    dep = 0
    while dep < len(temp):
        answer += (temp[dep] * (3 ** dep))
        dep += 1
    return answer

print(solution(45))