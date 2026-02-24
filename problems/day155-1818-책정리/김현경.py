import sys
from bisect import bisect_left

input = sys.stdin.readline

n = int(input().strip())
arr = list(map(int, input().split()))

lis = []

for x in arr:
    if not lis or lis[-1] < x:
        lis.append(x)
    else:
        idx = bisect_left(lis, x)
        lis[idx] = x

print(n - len(lis))