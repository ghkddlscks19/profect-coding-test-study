import sys
input = sys.stdin.readline

N = int(input())
data = []
for _ in range(N):
    data.append(input().rstrip().split())

if N == 1:
    pass

mc = 0
zc = 0
oc = 0

def solve(x,y,n):
    global mc, zc, oc

    first = data[x][y]
    same = True

    # 현재 구역이 전부 같은 값인지 검사
    for i in range(x, x+n):
        for j in range(y, y+n):
            if data[i][j] != first:
                same = False
                break
        if not same:
            break

    if same:
        if first == "-1":
            mc += 1
        elif first == "0":
            zc += 1
        else:
            oc += 1
        return

    step = n // 3
    for dx in range(3):
        for dy in range(3):
            solve(x + dx * step, y + dy * step, step)

solve(0, 0, N)

print(mc)
print(zc)
print(oc)