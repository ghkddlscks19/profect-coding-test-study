import sys
input = sys.stdin.readline

n = int(input())
a =list( map(int, input().split()))

dp =[1] *(n+1)
for i in range(n):
    for j in range(i):
        if a[j]<a[i]:
            dp[i] = max(dp[i], dp[j]+1)

maxLen = max(dp)
arr =[]
for i in range(n-1, -1, -1):
    if dp[i] == maxLen:
        arr.append(a[i])
        maxLen-=1

arr.reverse()
print(*(arr))

