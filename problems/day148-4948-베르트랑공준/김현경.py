import sys
import math
input = sys.stdin.readline
Max = 123456 * 2
arr = [True] *(Max+1)
arr[0] = False
arr[1] = False

for i in range(2,int(math.sqrt(Max))+1 ):
    if arr[i]:
        for j in range(i*2, Max+1,i):
            arr[j]=False

while True:
    n = int(input().strip())
    if n==0:
        break
    else:
        print(sum(arr[n+1: 2*n+1]))
