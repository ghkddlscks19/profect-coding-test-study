import sys
input = sys.stdin.readline

n = int(input())

amount = [0]
for _ in range(n):
    amount.append(int(input()))

if n == 1 or n == 2:
    print(sum(amount))
    exit(0)

dp = [0] * (n+1)
dp[1], dp[2] = amount[1], amount[1] + amount[2]

for i in range(3,n+1):
    dp[i] = max(dp[i-2] + amount[i], dp[i-3] + amount[i-1] + amount[i], dp[i-1])

print(max(dp))
