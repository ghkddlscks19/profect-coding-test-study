from collections import defaultdict

def solution(arrows):
    answer = 0
    dx = [0, 1, 1, 1, 0, -1, -1, -1]
    dy = [1, 1, 0, -1, -1, -1, 0, 1]
    graph = defaultdict(set)
    x, y = 0, 0
    for arrow in arrows:
        for _ in range(2):
            nx = x + dx[arrow]
            ny = y + dy[arrow]
            if (nx, ny) in graph and (x, y) not in graph[(nx, ny)]:
                answer += 1
            graph[(x, y)].add((nx, ny))
            graph[(nx, ny)].add((x, y))
            
            x, y = nx, ny
            
    return answer