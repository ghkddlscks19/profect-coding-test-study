import heapq,sys

n = int(input())
present = []
for _ in range(n):
    info = list(map(int,input().split()))
    if info[0] == 0:
        if len(present) == 0:
            print(-1)
            continue
        print(heapq.heappop(present) * -1)
        continue
    else:
        for i in range(1,len(info)):
            heapq.heappush(present,-info[i])
