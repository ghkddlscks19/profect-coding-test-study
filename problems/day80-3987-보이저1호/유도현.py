from collections import deque
import sys
input = sys.stdin.readline

n,m = map(int,input().split())
grid = []
for _ in range(n):
    grid.append(list(input().rstrip()))

sr,sc = map(int,input().split())
sr, sc = sr - 1, sc - 1
result, resultDirection = 0, ""
dr = [-1,0,1,0]
dc = [0,1,0,-1]

# 0,1,2,3 #위, 오른쪽, 아래, 왼쪽
directoryDir = {0:'U', 1:"R", 2:"D", 3:"L"}

def check(nr,nc,dir):
    if grid[nr][nc] == '\\':
        if dir == 0:
            dir = 3
        elif dir == 1:
            dir = 2
        elif dir == 2:
            dir = 1
        elif dir == 3:
            dir = 0
    elif grid[nr][nc] == '/':
        if dir == 0:
            dir = 1
        elif dir == 1:
            dir = 0
        elif dir == 2:
            dir = 3
        elif dir == 3:
            dir = 2
    return dir


def dfs(dir,visited,countVisited):
    q = deque()
    q.append([sr,sc,dir])
    countVisited[sr][sc] = 1
    visited[dir][sr][sc] = True
    while q:
        cr, cc, direction = q.popleft()
        nr = cr + dr[direction]
        nc = cc + dc[direction]
        if 0 <= nr < n and 0 <= nc < m:
            if not visited[direction][nr][nc]:
                if grid[nr][nc] == 'C': # 블랙홀이면 이전 값이 답
                    return countVisited[cr][cc]
                visited[direction][nr][nc] = True # 일단 방문 처리
                countVisited[nr][nc] = countVisited[cr][cc] + 1
                if grid[nr][nc] == '.':    
                    q.append([nr,nc,direction])
                    continue
                nextDir = check(nr,nc,direction) # 여기까지 왔다는 것은 행성 만났다는 것이고
                q.append([nr,nc,nextDir])
                continue
            else:
                return "Voyager"
        else:
            return countVisited[cr][cc]

for i in range(4):
    countVisited = [[0 for _ in range(m)] for _ in range(n)]
    visited = [[[False for _ in range(m)] for _ in range(n)] for _ in range(4)]
    count = dfs(i, visited, countVisited)
    if count == "Voyager":
        print(directoryDir[i])
        print("Voyager")
        exit(0)
    if count > result:
        result = count
        resultDirection = directoryDir[i]

print(resultDirection)
print(result)




# 어느 방향으로 신호를 보냈을 때 가장 오래 살아남아 있을 지를 출력하는건데
# 일단 모든 방향으로 보내보고 "무한으로 살아있을 수 있으면 그게 짱인 것이고"
# 근데 "무한으로 살아있다" <- 이것을 알려면 내가 밟은 위치를 한 번 더 밟냐 안 밟냐가 중요한데
# 한 번 더야 밟을 수야 있긴 한데 무조건 한 번 더 밟았다고 무한 루프인 것은 아닌데
# 시작점으로 왔는데 만약 같은 방향으로까지 시작점에 도착했으면 무한 루프 같은데
# 그러면 좌표에서 좌표만 visited처리를 하는 것이 아니라 방향까지 처리를 할라면 그냥 하나만 더 늘려서 이제 그게 방문했는지를 보면 되겠네
# 그리고 다시 생각해보니 굳이 시작점이 아니어도 같은 좌표를 같은 방향으로 온거면 이건 무한루프이네
