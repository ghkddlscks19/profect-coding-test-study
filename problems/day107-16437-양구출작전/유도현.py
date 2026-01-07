from collections import deque
import sys
input = sys.stdin.readline

n = int(input())

children = [[]for _ in range(n+1)]
sheep = [0] * (n+1)
wolf = [0] * (n + 1)

for i in range(2, n+1):
    t, a, p = input().rstrip().split()
    children[int(p)].append(i)
    if t == "S":
        sheep[i] = int(a)
    else:
        wolf[i] += int(a)

post = []
stack = [1]

while stack:
    c = stack.pop()
    post.append(c)
    for i in children[c]:
        stack.append(i)

total = [0] * (n+1)

for i in reversed(post):
    s = sheep[i] 
    for v in children[i]: 
        s += total[v] 
    s -= wolf[i]
    if s < 0:
        s = 0
    total[i] = s 

print(total[1])




