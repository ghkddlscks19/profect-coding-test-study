from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
data = deque(map(int, input().split()))     # 순서 유지 (정렬 X)
init = deque(range(1, n + 1))

result = 0

while data:
    target = data.popleft()

    idx = init.index(target)     # target의 현재 위치
    L = len(init)

    left = idx
    right = (L - idx) % L

    if left <= right:
        init.rotate(-left)       # 왼쪽으로 left번
        result += left
    else:
        init.rotate(right)       # 오른쪽으로 right번
        result += right

    init.popleft()               # target 제거 (맨 앞으로 온 상태)

print(result)
