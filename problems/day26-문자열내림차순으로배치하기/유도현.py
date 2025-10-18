def solution(s):
    answer = ''
    temp = []
    for i in s:
        temp.append(ord(i))
    temp.sort(reverse=True)
    for i in temp:
        answer += chr(i)
    return answer