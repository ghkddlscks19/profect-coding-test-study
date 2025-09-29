def solve(text):
    temp = ""
    for i in range(len(text)):
        if i % 2 == 0:
            temp += text[i].upper()
        else:
            temp += text[i].lower()
    return temp
def solution(s):
    answer = ''
    temp = ""
    for i in s:
        if i == " ": # 빈 칸이면 문제 해결하고, 빈칸 더해주고 답에 추가해주고 초기화도
            temp = solve(temp)
            temp += i
            answer += temp
            temp = ""
            continue
        temp += i
    answer += solve(temp)
    return answer