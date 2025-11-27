import math
def solution(n, k):
    answer = 0
    arr=[]
    while n:
        rest = n%k
        n=n//k
        arr.append(rest)
    #print(arr)
    arr.reverse()
    #print(arr)
    
    def isPrime(num):
        num = int(num)
        if num<=1:
            return False
        
        check = int(math.sqrt(num))
        for i in range(2, check+1):
            if num%i==0:
                return False
        return True
    
    arr = "".join(map(str,arr))
    #print(arr)
    arr2 = arr.split('0')
    #print(arr2)
    
    for i in arr2:
        if i:
            if isPrime(i):
                answer+=1
    
    # while arr:
    #     cur = arr.popleft()
        
    return answer