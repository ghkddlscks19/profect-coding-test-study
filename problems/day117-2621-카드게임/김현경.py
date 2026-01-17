# # 5장이 모두 같은 색이고, 숫자가 연속적일때 -> 
def one():
    return 900+sorted(num.keys())[-1]
    
# # 5중 4장의 숫자가 같을때 ->
def two(top):
    return 800+top

# # 5중 3장의 숫자가 같고, 나머지 2장의 숫자가 같을때 ->
def three(top, sec):
    return 700 + 10*top + sec

## 5장이 모두 같은 색일때  -> 
def four():
    return 600+sorted(num.keys())[-1]

# # 5장의 숫자가 모두 연속적일때 ->
def five():
    return 500+sorted(num.keys())[-1]

# # 5장의 숫자중 3개가 같을때  ->
def six(top):
    return 400+top

# # 5장의 숫자중 2개가 같고, 또 나머지중 2개가 같을때 ->
def seven(first, second):
    return 300+ first*10 +second
# # 5장 중 2장의 숫자가 같을때, 
def eight(top):
    return 200+top

num={}
color={}
arr=[]
for _ in range(5):
    c, n = input().split()
    n=int(n)
    arr.append([c,n])
    if n in num:
        num[n].append(c)
    else:
        num[n]=[c]
    if c in color:
        color[c].append(n)
    else:
        color[c]=[n]

def isSequence():
    checkList = sorted(num.keys())
    return len(checkList) == 5 and (checkList[-1] - checkList[0] == 4)


answer = 0
isCorresponed = False

if len(color.keys()) ==1 and isSequence():
    answer = max(answer, one())
    isCorresponed = True

if len(num.keys())==2:
    temp= sorted(num.keys(), key=lambda x: len(num[x]))
    top, sec = temp[-1],temp[0] 
    if len(num[top]) ==4:
        answer = max(answer, two(top ))
        isCorresponed = True
    elif len(num[top])==3:
        answer = max(answer, three(top, sec ))
        isCorresponed = True

if len(color.keys()) ==1:
    answer = max(answer, four())
    isCorresponed = True

if isSequence():
    answer= max(answer, five())
    isCorresponed = True

if len(num.keys())>=2:    
    temp= sorted(num.keys(), key=lambda x: len(num[x]))
    top,sec = temp[-1], temp[-2]
    if len(num[top]) ==3:
        answer= max(answer, six(top))
        isCorresponed = True
    if len(num[top])==2 and len(num[sec])==2:
        if top>sec:
           answer= max(answer, seven(top,sec))
        else:
           answer= max(answer, seven(sec,top))
        isCorresponed = True

if len(num.keys()) ==4:
    temp= sorted(num.keys(), key=lambda x: len(num[x]))
    top = temp[-1]
    answer= max(answer, eight(top))
    isCorresponed = True

if not isCorresponed:
    answer = 100+sorted(num.keys())[-1]

print(answer)