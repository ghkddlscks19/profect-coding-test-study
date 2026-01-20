import sys
from collections import deque

sys.setrecursionlimit(100000)

n = int(sys.stdin.readline())
adj = [[] for _ in range(n + 1)]
for _ in range(n):
    a, b = map(int, sys.stdin.readline().split())
    adj[a].append(b)
    adj[b].append(a)

is_cycle = [False] * (n + 1)
visited = [False] * (n + 1)
cycle_found = False

def find_cycle(curr, prev, path):
    global cycle_found
    visited[curr] = True
    path.append(curr)

    for nxt in adj[curr]:
        if not visited[nxt]:
            if find_cycle(nxt, curr, path):
                return True
        elif nxt != prev:
            start_idx = path.index(nxt)
            for i in range(start_idx, len(path)):
                is_cycle[path[i]] = True
            return True
    
    path.pop()
    return False

find_cycle(1, 0, [])

dist = [-1] * (n + 1)
queue = deque()

for i in range(1, n + 1):
    if is_cycle[i]:
        dist[i] = 0
        queue.append(i)

while queue:
    curr = queue.popleft()
    
    for nxt in adj[curr]:
        if dist[nxt] == -1:  
            dist[nxt] = dist[curr] + 1
            queue.append(nxt)

print(" ".join(map(str, dist[1:])))