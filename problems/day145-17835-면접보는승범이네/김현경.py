import sys
import heapq
input = sys.stdin.readline
n,m,k = map(int, input().split())
arr = [[] for _ in range(n+1)] 

for _ in range(m):
    u,v, c = map(int, input().split())
    arr[v].append((u,c))
# print(arr)

meet = list(map(int, input().strip().split()))
# print(meet)

dp=[float('inf')] *(n+1)
queue=[]
for m in meet:
    dp[m] = 0
    heapq.heappush(queue, (0,m))

while queue:
    dist, curr = heapq.heappop(queue)
    if dist>dp[curr]:
        continue

    for next in arr[curr]:
        nC, nW = next
        cost = nW+dist
        if cost < dp[nC]:
            dp[nC] = cost
            heapq.heappush(queue, (cost, nC))

maxDist = float('-inf')
answer =0

for i in range(1, n+1):
    if dp[i] != float('inf'):
        if dp[i] > maxDist:
            maxDist = dp[i]
            answer = i

print(f"{answer}\n{maxDist}")
# print(maxDist)
