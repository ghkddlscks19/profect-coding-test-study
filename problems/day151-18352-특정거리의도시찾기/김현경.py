import sys
from collections import deque
input = sys.stdin.readline
#도시수, 도로수, 거리정보, 출발도시번호
n,m,k,x = map(int, input().split())
arr = [[] for _ in range(n+1)]

for _ in range(m):
    a,b = map(int, input().split())
    arr[a].append(b)

dist = [-1] *(n+1)
dist[x]=0
queue =deque([x])

while queue:
    cur = queue.popleft()
    for next in arr[cur]:
        if dist[next] == -1:
            dist[next] = dist[cur]+1
            queue.append(next)

answer =[]
for i in range(len(dist)):
    if dist[i]==k:
        answer.append(i)

if len(answer) ==0:
    print(-1)
else:
    for ans in answer:
        print(ans)