import sys
input = sys.stdin.readline
n =int(input())
arrT = [0] * (n + 1)
arrP = [0] * (n + 1)
dp=[0] * (n + 2)
for i in range(1,n+1):
    arrT[i], arrP[i] = map(int, input().split())

for i in range(n, 0,-1):
    if i+arrT[i]>n+1:
        dp[i] = dp[i+1]
    else:
        dp[i] = max(dp[i+arrT[i]]+arrP[i], dp[i+1])

print(dp[1])
