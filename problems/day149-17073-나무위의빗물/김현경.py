import sys
input = sys.stdin.readline
n,w = map(int, input().split())
tree = [[] for _ in range(n+1)]

for _ in range(n-1):
    u,v = map(int, input().split())
    tree[u].append(v)
    tree[v].append(u)

# print(tree)

ans=0
for i in range(2, n+1):
    if len(tree[i])==1:
        ans+=1

# print(ans)

print(f"{w / ans:.10f}")