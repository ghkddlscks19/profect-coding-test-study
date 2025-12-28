from collections import deque
A, K = map(int,input().split())

q = deque()
q.append([A,0])
visited = [0] * 1000001
visited[A] = 1
while q:
    number, cnt = q.popleft()
    if number == K:
        print(cnt)
        exit(0)
    if number + 1 <= 1000000 and not visited[number + 1]:
        visited[number + 1] = 1
        q.append([number + 1, cnt + 1])
    if number * 2 <= 1000000 and not visited[number * 2]:
        visited[number * 2] = 1
        q.append([number * 2, cnt + 1])





# +1, *2c