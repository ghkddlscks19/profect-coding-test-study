import sys
input= sys.stdin.readline
a,b = map(int, input().split())
answer = 0

def check(num):
    global answer
    if num >b:
        return 
    if num>=a:
        answer+=1
    check(num*10+4)
    check(num*10+7)

    
check(4)
check(7)
    
print(answer)