from collections import deque

def solution(maps):
    answer = -1
    n = len(maps)
    m = len(maps[0])
    dist = [[0]*m for _ in range(n)]
    
    dx=[-1,1,0,0]
    dy=[0,0,-1,1]

    queue = deque([(0,0)])
    dist[0][0] = 1
    
    while queue:
        x,y = queue.popleft()
        
        if x==n-1 and y==m-1:
            return dist[x][y]
        
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if 0<=nx<=n-1 and 0<=ny<=m-1 and maps[nx][ny] ==1 and dist[nx][ny] ==0:
                dist[nx][ny] = dist[x][y]+1
                queue.append((nx,ny))
                
    return answer