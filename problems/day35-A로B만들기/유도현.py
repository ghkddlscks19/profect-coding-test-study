def solution(before, after):
    answer = 1
    a = [0] * 26
    b = [0] * 26
    for i in before:
        a[ord(i) - 97] += 1
    for i in after:
        b[ord(i) - 97] += 1
    
    for i in range(26):
        if a[i] != b[i]:
            return 0
    return answer