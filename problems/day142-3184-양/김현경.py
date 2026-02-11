import sys
from collections import deque
input = sys.stdin.readline
r,c = map(int, input().split())
arr = [list(input().strip()) for _ in range(r)]
isVisited = [[False]*c for _ in range(r)]
dx = [-1,1,0,0,]
dy = [0,0,-1,1]
# print(arr)
allSheep=0
allWolf=0
for i in range(r):
   for j in range(c):
      if isVisited[i][j] == False and arr[i][j] != '#':
        sheep = 0
        wolf = 0
        queue = deque()
        queue.append((i,j))
        isVisited[i][j] = True

        while queue:
            cx,cy = queue.popleft()
            if arr[cx][cy]=='o':
                sheep += 1
            elif arr[cx][cy]=='v':
                wolf += 1
            for k in range(4):
               nx = cx+dx[k]
               ny = cy+dy[k]
               if 0<=nx<r and 0<=ny<c:
                  if isVisited[nx][ny] == False and arr[nx][ny] != '#':
                        isVisited[nx][ny] = True
                        queue.append((nx,ny))
        if sheep > wolf:
            allSheep += sheep
        else:
              allWolf += wolf   

print(f"{allSheep} {allWolf}")