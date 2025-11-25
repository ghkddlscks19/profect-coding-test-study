from collections import deque

def bfs(r,c,maps):
    q = deque()
    q.append([0,0])    
    visited = [[0] * c for _ in range(r)]
    visited[0][0] = 1
    moving = [[-1,0], [1,0], [0,-1], [0,1]]
    while q:
        x,y = q.popleft()
        for move in moving:
            nx = x + move[0]
            ny = y + move[1]
            if 0 <= nx < r and 0 <= ny < c and maps[nx][ny] == 1:
                if not visited[nx][ny]:
                    visited[nx][ny] = visited[x][y] + 1
                    q.append([nx,ny])
    return visited[r-1][c-1]
                
def solution(maps):
    r,c = len(maps), len(maps[0])
    answer = bfs(r,c,maps)
    if answer == 0:
        return -1
    else:
        return answer