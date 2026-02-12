import sys
input = sys.stdin.readline
n = int(input().strip())
arr = []
answer=0
for i in range(n):
    temp=[]
    temp.append(input().split())
    if temp[0][0]=='1':
        score, min = temp[0][1], temp[0][2]
        if int(min)-1 ==0:
            answer+=int(score)
        else:
            arr.append([int(score), int(min)-1])
    else:
        if arr:
            score, min = arr.pop()
            min-=1
            if min==0:
                answer+=score
            else:
                arr.append([score, min])


print(answer)
