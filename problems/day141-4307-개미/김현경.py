import sys
import math 
input = sys.stdin.readline
n =int(input().strip())

for _ in range(n):
    stickLen, num = map(int, input().split())
    arr = []
    for j in range(num):
        a = int(input().strip())
        arr.append(a)
    
    maxNum = float("-inf")
    minNum =  float("-inf")

    for a in arr:
        checkMin = min(a, stickLen-a)
        checkMax = max(a, stickLen-a)
        minNum = max(minNum, checkMin)
        maxNum = max(maxNum, checkMax)
    
    print(f"{minNum} {maxNum}")
