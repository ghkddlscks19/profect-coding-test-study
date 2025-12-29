import sys

dp=[0]*251
dp[1]=1
dp[2]=3

for i in range(3, 251):
    dp[i]= dp[i-1] +dp[i-2]*2

arr = sys.stdin.readlines()
for i in arr:
    n = int(i)
    print(dp[n])