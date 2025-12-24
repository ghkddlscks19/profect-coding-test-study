from itertools import combinations
import sys
input = sys.stdin.readline

n = int(input())
stemina = list(map(int,input().split()))
happy = list(map(int,input().split()))

if sum(stemina) == n * 100:
    print(0)

maxHappy = 0

idxList = [i for i in range(0, n)]

def solve(lis):
    global maxHappy
    tempHappy, tempStemina = 0,0
    for i in lis:
        tempHappy += happy[i]
        tempStemina += stemina[i]
    
    if tempStemina <= 99:
        maxHappy = max(maxHappy, tempHappy)

for i in range(1,n+1):
    for lis in combinations(idxList, i):
        solve(lis)

print(maxHappy)
