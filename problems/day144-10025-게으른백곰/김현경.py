import sys
input = sys.stdin.readline

n, k = map(int, input().split())
arr = [0] * 1000001
maxX = 0

for _ in range(n):
    g, x = map(int, input().split())
    arr[x] = g
    if x > maxX:
        maxX = x

size = 2 * k + 1

currentSum = sum(arr[:size])
maxSum = currentSum

for i in range(size, 1000001):
    currentSum += arr[i] - arr[i - size]
    if currentSum > maxSum:
        maxSum = currentSum

print(maxSum)