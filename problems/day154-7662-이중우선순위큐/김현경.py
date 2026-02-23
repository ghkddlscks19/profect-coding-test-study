import sys
import heapq
input = sys.stdin.readline

t = int(input().strip())

for _ in range(t):
    k = int(input().strip())
    origin =[] 
    reversed =[] 
    isValid = [False] *k

    for i in range(k):
        oper, num = input().split()
        num = int(num)
        if oper == "I":
            heapq.heappush(origin,(num,i))
            heapq.heappush(reversed, (-num,i))
            isValid[i]=True
        else:
            if num==1:
                while reversed and not isValid[reversed[0][1]]:
                    heapq.heappop(reversed)
                if reversed:
                    val, idx = heapq.heappop(reversed)
                    isValid[idx] = False
            else:
                while origin and not isValid[origin[0][1]]:
                    heapq.heappop(origin)
                if origin:
                    val,idx = heapq.heappop(origin)
                    isValid[idx] = False

    while reversed and not isValid[reversed[0][1]]:
        heapq.heappop(reversed)
    while origin and not isValid[origin[0][1]]:
        heapq.heappop(origin)
        
    if not origin:
        print("EMPTY")
    else:
        arr=[]
        arr.append(-heapq.heappop(reversed)[0])
        arr.append(heapq.heappop(origin)[0])
        print(*(arr))