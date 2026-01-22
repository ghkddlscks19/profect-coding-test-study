a,b = map(int, input().split())
answer=1
while True:
    #print(b)
    if b==a:
        break
    if b<a:
        answer=-1
        break
    #만약 끝자리가 1이 아닌 홀수가 나오면 return -1
    listB = list(str(b))
    if listB[-1] in ['3','5','7','9']:
        answer=-1
        break
    #1이 나오면 
    elif listB[-1] == "1":
        newB = listB[:-1]
        b = "".join(newB)
        b = int(b)
        answer+=1
    #짝수면 나오면 
    else:
        b = b//2
        answer+=1

print(answer)