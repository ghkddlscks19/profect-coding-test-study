import math

n, s = map(int, input().split())
arr= list(map(int, input().split()))
min = [0]*n
min[0] = abs(s-arr[0])
for i in range(1, n):
    min[i] = abs(arr[i]-arr[i-1])

def commonMax(list):
    result = list[0]
    for i in range(1, len(list)):
        result = math.gcd(result, list[i])

    return result

print(commonMax(min))