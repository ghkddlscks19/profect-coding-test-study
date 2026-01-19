import sys
from collections import deque
from itertools import combinations
map= []
arr=[]
dx = [-1,1,0,0]
dy =[0,0,-1,1]
answer=0

for _ in range(5):
    line = sys.stdin.readline().strip()
    if line:
        map.append(list(line))

for i in range(5):
    for j in range(5):
        arr.append((i,j))

for comb in combinations(arr,7):
    cnt=0
    for c in comb:
        x, y = c
        if map[x][y] == 'S':
            cnt+=1
    if cnt<4:
        continue

    queue = deque([comb[0]])
    isVisited = [comb[0]]

    while queue:
        cx, cy = queue.popleft()
        for i in range(4):
            nx = cx+dx[i]
            ny = cy+dy[i]
            if (nx,ny) in comb and (nx,ny) not in isVisited:
                isVisited.append((nx,ny))
                queue.append((nx,ny))
    
    if len(isVisited) ==7:
        answer+=1

print(answer)