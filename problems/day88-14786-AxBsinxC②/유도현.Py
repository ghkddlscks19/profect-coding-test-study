from collections import deque
import sys
input = sys.stdin.readline
n,question = map(int,input().split())
graph = [[] for _ in range(n+1)]
for i in range(n-1):
    p,q,r = map(int,input().split())
    graph[p].append([q,r])
    graph[q].append([p,r])

def solve(k,v):
    count = 0
    q = deque()
    q.append(v)    
    visited = [0] * (n+1)
    visited[v] = 1
    while q:
        node = q.popleft()
        for next, usado in graph[node]:
            if not visited[next]:
                if k <= usado:
                    visited[next] = 1
                    q.append(next)
                    count += 1
    return count

for i in range(question):
    k,v = map(int,input().split())
    print(solve(k,v))