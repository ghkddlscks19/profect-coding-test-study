import sys
input = sys.stdin.readline

N,S = map(int,input().split())
spots = list(map(int,input().split()))

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

result = 0

for spot in spots:
    dist = abs(spot - S)
    result = gcd(result, dist)

print(result)



# N이 십만 명인데, x 좌표 최댓값은 십억 흠...., 근데 이건 브루트포스인척하는 그냥 문제인데
# S로부터 모든값을 다 빼보고 거기서 가장 작은 값을 절댓값 씌운 것이 답이지 