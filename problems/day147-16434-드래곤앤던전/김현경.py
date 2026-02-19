import sys
import math
input = sys.stdin.readline

n, atk = map(int, input().split())

curHp = 0
minHp=0

list=[]
for _ in range(n):
    t, a, h = map(int, input().split())

    #몬스터가 있는 경우
    if t==1:
        num = (h-1)//atk
        curHp -= (num*a)
        if curHp<minHp:
            minHp = curHp

    # 물략이 있는 경우
    else:
        atk += a
        curHp += h
        if 0 < curHp:
            curHp=0

print(abs(minHp) + 1)