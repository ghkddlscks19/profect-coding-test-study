import sys
input =sys.stdin.readline

arr = list(input().strip().rstrip(";").replace(",","").split())

if len(arr)>1:
    base = arr[0]
    for i in range(1,len(arr)):
        origin = arr[i]
        name =""
        front = ""
        for o in origin:
            if o.isalpha():
                name+=o
            else:
                front+=o
        revFront = front[::-1].replace("][","[]")
        # print(revFront)
        answer = base+revFront+" "+name+";"
        print(answer)