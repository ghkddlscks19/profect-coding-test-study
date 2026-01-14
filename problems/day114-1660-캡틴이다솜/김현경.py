n=int(input())
boundary =[]
increase=1
tri=0
tetra=0
while True:
    tri+=increase
    tetra+=tri
    if tetra>n:
        break
    boundary.append(tetra)
    increase+=1

dp = [float('inf')] * (n + 1)
dp[0]=0
