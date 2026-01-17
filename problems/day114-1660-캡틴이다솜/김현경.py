import sys
n=int(sys.stdin.readline())

tri = 0
tetra=0
plus=1
bound =[]
while True:
    tri+=plus
    tetra+=tri
    if tetra>n:
        break
    bound.append(tetra)
    plus+=1

dp = [float('inf')] * (n+1)
dp[0] = 0
dp[1]=1

for i in range(2, n+1):
    for b in bound:
        if b>i:
            break
        if b==i:
            dp[i]=1
            break
        if dp[i]>dp[i-b]+1:
            dp[i]=dp[i-b]+1
        
print(dp[n])