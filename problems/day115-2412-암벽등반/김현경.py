import sys
from collections import deque

input = sys.stdin.readline

n, t = map(int, input().split())

adj={}
for i in range(n):
    x, y = map(int, input().split())
    if y not in adj:
        adj[y]=[]
    adj[y].append(x)

isVisited = [False] * n
queue = deque([(0, 0, 0)])  
answer=-1

while queue:
    cx, cy, dist = queue.popleft()
    if cy == t:
        answer = dist
        break

    for ny in range(cy-2, cy+3):
        if ny in adj:
            candX = adj[ny]
            notVisitedX = []
            for nx in candX:
                if abs(cx-nx)<=2:
                    queue.append((nx,ny,dist+1))
                else:
                    notVisitedX.append(nx)
            adj[ny] = notVisitedX


print(answer)