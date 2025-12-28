a, k = map(int, input().split())
dp = [float('inf')] * (k + 1)

dp[a] = 0

for i in range(a + 1, k + 1):
    dp[i] = dp[i-1] + 1
    if i % 2 == 0 and i // 2 >= a:
        dp[i] = min(dp[i], dp[i//2] + 1)

print(dp[k])