import sys
input = sys.stdin.readline

n = int(input().strip())
arr = list(map(int, input().split()))
check = [False] * n

for i in range(n):
    bound = 0
    leftRemain = arr[i]

    while True:
        if  not check[bound]:
            if leftRemain ==0:
                check[bound] = i+1
                break
            else:
                leftRemain-=1
        bound+=1

print(*(check))