n =int(input())
m = list(map(int, input().split()))
p =  list(map(int, input().split()))
ans =0 

def dfs(i, strength,happy):
    global ans

    if strength-minus<=0:
        return 
    
    if i==n:
        ans = max(ans, happy)
        return 
    
    while stack:
        for i in range(node+1,n):
            next_strength =  strength-minus
            next_happy = happy+plus
            total = dfs(i, next_strength, next_happy)
        

dfs(0,100,0)
    
print(ans)
    