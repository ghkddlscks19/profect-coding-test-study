import sys
input = sys.stdin.readline

n = int(input())
data = list(map(int,input().split()))

data.sort()
ans = 0

for i in range(n-2): # 두 개 이전까지
    l,r = i + 1, n - 1 # 지금 기준 보다 딱 한 칸 더 큰 값, 가장 큰 값
    while l < r: # 둘이 같은 인덱스면 안 되니 r이 l보다 큰 경우
        s = data[i] + data[l] + data[r]
        if s < 0:
            l += 1
        elif s > 0:
            r -= 1
        else:
            # s == 0
            if data[l] == data[r]:
                k = r - l + 1
                ans += k * (k - 1) // 2
                break
            else:
                left_val = data[l]
                right_val = data[r]

                cntL = 0
                while l < r and data[l] == left_val:
                    l += 1
                    cntL += 1

                cntR = 0
                while l <= r and data[r] == right_val:
                    r -= 1
                    cntR += 1
                
                ans += (cntL * cntR)

print(ans)


# 학생 수는 최댄 만 명
# 만 명을 최대 3개의 조합으로 묶었을 때 0이되는 조합을 찾아야 한다. 딱 봐도 조합으로 풀면 시간 초과 발생해서 풀 수가 없다.
# 그러면 문제 조건을 다시 봐보자면 3개를 합쳤을 때 합이 0이 되는 것을 찾아야 하는데
# 3개니깐 0이 껴있지 않는 이상 음수 두개와 양수 하나, 양수 두개거나 음수 하나
# 0이하나 양수,음수 하나씩, 0 두개는 말 안되고 0이 세개인 조합도 된다.
# 그럼 만약 숫자를 정렬하면 포인터를 세 개 두어야 하나? 
# 탐색 범위가 크지 않는데도 않는데도 이분 탐색을 써야한다라... 그리고 포인터는 왜 두 개지? 
