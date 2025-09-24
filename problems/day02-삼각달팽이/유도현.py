def solve(start, cnt, move, data, n, r, c):
    if move == 0: # 아래로 움직여
        while r < n + 1 and len(data[r][c]) == 0:
            data[r][c].append(start)
            cnt += 1
            start += 1
            r += 1                
    elif move == 1: # 오른쪽으로 움직여
        while c < r and len(data[r][c]) == 0:
            data[r][c].append(start)
            cnt += 1
            start += 1
            c += 1
    elif move == 2: # 위로 움직여
        while r > 1 and len(data[r][c]) == 0:
            data[r][c].append(start)
            cnt += 1
            r -= 1
            c -= 1
            start += 1
    
    if move == 0:
        r -= 1
        c += 1

    if move == 1:
        c -= 2
        r -= 1

    if move == 2:
        r += 2
        c += 1
    return start, cnt, r, c
            
def solution(n):
    answer = []
    data = [[[] for _ in range(i)]for i in range(n+1)]
    start, cnt,move = 1,0,0 # move 0은 밑, 1은 오른쪽, 2는 위
    end = (1+n) * n // 2
    r,c = 1,0 # r은 +1이지만 c는 +1을 안 함.
    while cnt < end:
        start,cnt,r,c = solve(start,cnt,move,data,n,r,c)
        move = (move + 1) % 3
    
    for i in range(1, n+1):
        for j in range(i):
            answer.append(data[i][j][0])
    return answer
