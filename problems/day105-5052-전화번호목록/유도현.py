from collections import defaultdict
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    if n == 1:
        print("YES")
        continue
    phone_number = []
    len_number = set()
    len_dict = defaultdict(set)
    for _ in range(n):
        pn = input().rstrip()      
        phone_number.append(pn)
        len_number.add(len(pn))
        len_dict[len(pn)].add(pn)
    phone_number.sort(key = lambda x : len(x))
    flag = 0
    for i in range(1, len(phone_number)):
        curNum = phone_number[i] 
        for lenNum in len_number:
            if len(curNum) == lenNum:
                continue
            if curNum[:lenNum] in len_dict[lenNum]:
                print("NO")
                flag = 1
                break
        if flag:
            break
    if not flag:
        print("YES")

# 테케 50개, 전화번호수 최대 10000, 전화번호는 최대 10자리
# 길이가 짧은 순서부터 정렬을 해보자. 길이가 짧은 것이 다른 것에 접두어가 되는 경우가 많고 게산하기 쉬우니깐
