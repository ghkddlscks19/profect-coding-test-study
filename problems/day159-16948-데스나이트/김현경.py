import sys
from collections import deque
input = sys.stdin.readline
way= [[-2,-1],[-2,1],[0,-2],[0,2],[2,-1],[2,1]]

n = int(input())
arr =list(input().strip().split())
r1 = int(arr[0])
c1 =int(arr[1])
r2 =int(arr[2])
c2 = int(arr[3])

queue = deque([(r1,c1,0)])
isVisited = [[False] *n for _ in range(n)]
isVisited[r1][c1] = True
answer = 0
isFound= False
while queue:
    cx, cy,num = queue.popleft()
    if cx ==r2 and cy==c2:
        isFound = True
        answer = num
        break
    for xw,yw in way:
        nx = cx+xw
        ny = cy +yw
        if 0<=nx<n and 0<=ny<n:
            if not isVisited[nx][ny]:
                isVisited[nx][ny] =True
                queue.append((nx,ny,num+1))

if isFound:
    print(answer)
else:
    print(-1)

